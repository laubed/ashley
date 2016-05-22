package com.badlogic.ashley.serialization;

import static org.junit.Assert.*;

import com.badlogic.ashley.core.Component;
import org.junit.Test;

/**
 * Created by David on 21/05/2016.
 */
public class DefaultComponentCreatorTests {

    public static class TestComponent implements Component {}

    @Test
    public void create() {
        DefaultComponentCreator creator = new DefaultComponentCreator();
        Component component = creator.create(TestComponent.class);
        assertNotNull(component);
        assertEquals(TestComponent.class, component.getClass());
    }
}
