package com.badlogic.ashley.serialization;

import com.badlogic.ashley.core.Entity;

/**
 * Entity creation strategy interface.
 *
 *  When working with {@link Engine}, you can use {@link DefaultEntityCreator},
 *  whereas whenever you use {@link PooledEngine}, you should be using
 *  {@link PooledEntityCreator}.
 *
 * @author David Saltares
 */
public interface EntityCreator {
    /**
     * @return new Entity instance.
     */
    public Entity create();
}
