package org.nameapi.ontology5.input.context;

import com.google.common.base.Optional;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * @author Gabriela Achim
 */
public class ContextPropertiesTest {

    private static ContextProperties contextProperties;
    static {
        Map<String, String> properties = new HashMap<>();
        properties.put("key1", "string");
        properties.put("key2", "True");
        properties.put("key20", "ture");
        properties.put("key3", "1000");
        properties.put("key4", "10.55d");
        contextProperties = ContextProperties.forMap(properties);
    }

    @Test
    public void testHasProperty() throws Exception {
        assertTrue(contextProperties.hasProperty("key1"));
        assertFalse(contextProperties.hasProperty("dsadasd"));
    }
    @Test
    public void testGetString() throws Exception {
        assertEquals(contextProperties.getString("key1").get(), "string");
        assertEquals(contextProperties.getString("key100"), Optional.<String>absent());
    }


    @Test
    public void testIsBoolean() throws Exception {
        assertTrue(contextProperties.isBoolean("key2"));

        assertFalse(contextProperties.isBoolean("xxxx"));//property that doesn't exist
        assertFalse(contextProperties.isBoolean("key4"));//property that is not boolean
    }
    @Test
    public void testGetBoolean() throws Exception {
        assertEquals(contextProperties.getBoolean("key2").get(), Boolean.TRUE);
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void testInvalidBoolean() throws Exception {
        contextProperties.getBoolean("key20");
        contextProperties.getBoolean("key3");
    }

    @Test
    public void testGetInteger() throws Exception {
        assertEquals((int)contextProperties.getInteger("key3").get(), 1000);
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void testInvalidInteger() throws Exception {
        contextProperties.getInteger("key1");
    }

    @Test
    public void testGetDouble() throws Exception {
        assertEquals(contextProperties.getDouble("key4").get(), 10.55d);
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void testInvalidDouble() throws Exception {
        contextProperties.getDouble("key1");
    }
}
