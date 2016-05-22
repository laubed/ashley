package com.badlogic.ashley.serialization;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 21/05/2016.
 */
public class DefaultEntityCreatorTests {
    @Test
    public void create() {
        DefaultEntityCreator creator = new DefaultEntityCreator();
        Entity entity = creator.create();
        assertNotNull(entity);
    }
}