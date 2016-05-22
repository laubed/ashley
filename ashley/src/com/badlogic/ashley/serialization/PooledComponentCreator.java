package com.badlogic.ashley.serialization;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.PooledEngine;

/**
 * Pooled Component creation strategy implementation.
 *
 * It requires a {@link PooledEngine}.
 *
 * @author David Saltares
 */
public class PooledComponentCreator implements ComponentCreator {
    private final PooledEngine engine;

    public PooledComponentCreator(PooledEngine engine) {
        this.engine = engine;
    }

    @Override
    public Component create(Class<? extends Component> componentType) {
        return engine.createComponent(componentType);
    }
}
