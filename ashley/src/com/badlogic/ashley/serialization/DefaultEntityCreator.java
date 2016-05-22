package com.badlogic.ashley.serialization;

import com.badlogic.ashley.core.Entity;

/**
 * Default Entity creation strategy implementation.
 *
 * @author David Saltares
 */
public class DefaultEntityCreator implements EntityCreator {
    @Override
    public Entity create() {
        return new Entity();
    }
}
