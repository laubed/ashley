package com.badlogic.ashley.serialization;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

/**
 * Handles serialization and deserialization of entities and their
 * components to and from Json.
 *
 * @author David Saltares
 */
public class EntitySerializer implements Json.Serializer<Entity> {
    private final EntityCreator entityCreator;
    private final ComponentCreator componentCreator;

    /**
     * Entity and component creation strategies are taken so the
     * client can either use regular or pooled objects as well
     * as any other allocation technique.
     *
     * @param entityCreator entity creation strategy.
     * @param componentCreator component creation strategy.
     */
    public EntitySerializer(EntityCreator entityCreator,
                            ComponentCreator componentCreator) {
        this.entityCreator = entityCreator;
        this.componentCreator = componentCreator;
    }

    @Override
    public void write(Json json, Entity entity, Class knownType) {
        json.writeObjectStart();
        json.writeObjectStart("components");
        for (Component component : entity.getComponents()) {
            if (isTransient(component)) {
                continue;
            }
            write(json, component);
        }
        json.writeObjectEnd();
        json.writeObjectEnd();
    }

    @Override
    public Entity read(Json json, JsonValue jsonData, Class type) {
        try {
            Entity entity = entityCreator.create();

            JsonValue components = jsonData.get("components");
            for (JsonValue componentValue : components) {
                Component component = read(json, componentValue);
                entity.add(component);
            }

            return entity;
        } catch (ReflectionException e) {
            return null;
        }
    }

    private boolean isTransient(Component component) {
        Class componentType = component.getClass();
        return ClassReflection.getAnnotation(componentType, Transient.class) != null;
    }

    private Component read(Json json, JsonValue componentValue) throws ReflectionException {
        String className = componentValue.name();
        Class componentType = getClass(json, className);
        Component component = componentCreator.create(componentType);
        json.readFields(component, componentValue);
        return component;
    }

    private void write(Json json, Component component) {
        String tag = getTag(json, component);
        json.writeObjectStart(tag);
        json.writeFields(component);
        json.writeObjectEnd();
    }

    private static String getTag(Json json, Component component) {
        Class type = component.getClass();
        String tag = json.getTag(type);
        return tag != null ? tag : type.getName();
    }

    private static Class getClass(Json json, String name) throws ReflectionException {
        Class type = json.getClass(name);
        return type != null ? type : ClassReflection.forName(name);
    }
}
