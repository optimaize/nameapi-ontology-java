package org.nameapi.ontology5.input.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nameapi.ontology5.BaseJsonTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 *
 */
public class ContextJsonTest extends BaseJsonTest {

    @Test
    public void simple() throws Exception {
        Context original = new ContextBuilder()
                .build();

        validate(original);
    }

    @Test
    public void all() throws Exception {
        Context original = new ContextBuilder()
                .priority(Priority.REALTIME)
                .place("DE")
                .language("de")
                .writingSystem("Latn:de")
                .textCase(TextCase.TITLE_CASE)
                .property("foo", "bar")
                .build();
        assertEquals(original.getPriority(), Priority.REALTIME);
        assertEquals(original.getWritingSystems().get(0), "Latn:de");
        assertTrue(original.getTextCase().get() == TextCase.TITLE_CASE);
        assertTrue(original.getPlace().isPresent());
        assertEquals(original.getPlace().get(), "DE");
        assertEquals(original.getLanguage().get(), "de");
        assertEquals(original.getContextProperties().getString("foo").get(), "bar");

        validate(original);
    }


    private void validate(Context original) throws java.io.IOException {
        ObjectMapper jackson = mapper();
        String json = jackson.writeValueAsString(original);
        Context recreated = jackson.readValue(json, Context.class);
        assertEquals(recreated, original);
    }

}