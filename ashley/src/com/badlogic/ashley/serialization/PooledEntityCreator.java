package com.badlogic.ashley.serialization;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;

/**
 * Pooled Entity creation strategy implementation.
 *
 * It requires a {@link PooledEngine}.
 *
 * @author David Saltares
 */
public class PooledEntityCreator implements EntityCreator {
    private final PooledEngine engine;

    public PooledEntityCreator(PooledEngine engine) {
        this.engine = engine;
    }

    @Override
    public Entity create() {
        return engine.createEntity();
    }
}
