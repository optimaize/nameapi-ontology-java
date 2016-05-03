package org.nameapi.ontology5.input.context;

import org.nameapi.ontology5.input.entities.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Gabriela Achim
 */
public class ContextPropertyTest extends BaseTest {

    @Test
    public void testTransform_emptyName() throws Exception {
        ContextProperty contextProperty = new ContextProperty("", "value");
        ContextProperty mod = contextProperty.transform(nullTransformer());
        assertEquals(mod, null);
    }

    @Test
    public void testTransform_emptyValue() throws Exception {
        ContextProperty contextProperty = new ContextProperty("name", "");
        ContextProperty mod = contextProperty.transform(nullTransformer());
        assertEquals(mod, null);
    }

    @Test
    public void testTransform_empty() throws Exception {
        ContextProperty contextProperty = new ContextProperty("", "");
        ContextProperty mod = contextProperty.transform(nullTransformer());
        assertEquals(mod, null);
    }

    @Test
    public void testTransform_notEmpty() throws Exception {
        ContextProperty contextProperty = new ContextProperty("name", "value");
        ContextProperty mod = contextProperty.transform(nullTransformer());
        assertEquals(mod, null);
    }
}
