package com.badlogic.ashley.serialization;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.utils.Pool;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 21/05/2016.
 */
public class PooledEntityCreatorTests {
    @Test
    public void create() {
        PooledEngine engine = new PooledEngine();
        PooledEntityCreator creator = new PooledEntityCreator(engine);
        Entity entity = creator.create();
        assertNotNull(entity);
        assertTrue(entity instanceof Pool.Poolable);
    }
}