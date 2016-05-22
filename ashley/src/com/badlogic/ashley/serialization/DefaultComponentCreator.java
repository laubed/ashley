package com.badlogic.ashley.serialization;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

/**
 * Default implementation of the component creation strategy interface.
 *
 * @author David Saltares
 */
public class DefaultComponentCreator implements ComponentCreator {
    /**
     * @return new component instance of the specified type or null whenever
     * the component cannot be instantiated.
     */
    @Override
    public Component create(Class<? extends Component> componentType) {
        try {
            return ClassReflection.newInstance(componentType);
        } catch (ReflectionException e) {
            return null;
        }
    }
}
