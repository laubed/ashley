package com.badlogic.ashley.serialization;

import com.badlogic.ashley.core.Component;

/**
 * Component creation strategy interface.
 *
 *  When working with {@link Engine}, you can use {@link DefaultComponentCreator},
 *  whereas whenever you use {@link PooledEngine}, you should be using
 *  {@link PooledComponentCreator}.
 *
 * @author David Saltares
 */
public interface ComponentCreator {
    /**
     * @return new {@link Component} instance of the specified type.
     */
    public Component create(Class<? extends Component> componentType);
}
