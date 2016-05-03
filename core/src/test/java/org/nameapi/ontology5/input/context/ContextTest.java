package org.nameapi.ontology5.input.context;

import org.nameapi.ontology5.input.entities.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Nicole Torres
 */
public class ContextTest extends BaseTest {

    @Test
    public void withTextCase() throws Exception {
        Context context1 = new ContextBuilder()
                .priority(Priority.REALTIME)
                .build();
        Context context2 = context1.withTextCase(TextCase.LOWER_CASE);
        assertNotEquals(context1, context2);
        assertFalse(context1.getTextCase().isPresent());
        assertEquals(context2.getTextCase().get(), TextCase.LOWER_CASE);
    }

    @Test
    public void transform_1() throws Exception {
        Context context = new ContextBuilder()
                .priority(Priority.REALTIME)
                .language("fr")
                .property("key", "value")
                .build();

        Context mod = context.transform(nullTransformer());
        assertEquals(mod, null);
    }

    @Test
    public void transform_2() throws Exception {
        Context context = new ContextBuilder()
                .priority(Priority.REALTIME)
                .language("fr")
                .property("key", "value")
                .textCase(TextCase.LOWER_CASE)
                .build();

        Context mod = context.transform(nullTransformer());
        Context expected = new ContextBuilder()
                .priority(Priority.REALTIME)
                .textCase(TextCase.LOWER_CASE)
                .build();

        assertEquals(mod, expected);
    }

}
