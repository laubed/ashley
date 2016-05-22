package com.badlogic.ashley.serialization;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.PooledEngine;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 21/05/2016.
 */
public class PooledComponentCreatorTests {

    public static class TestComponent implements Component {}

    @Test
    public void create() {
        PooledEngine engine = new PooledEngine();
        PooledComponentCreator creator = new PooledComponentCreator(engine);
        Component component = creator.create(TestComponent.class);
        assertNotNull(component);
        assertEquals(TestComponent.class, component.getClass());
    }
}