package org.nameapi.ontology5.input.context;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

/**
 * @author sam
 */
public class ContextBuilderTest {

    @Test
    public void minimal() throws Exception {
        new ContextBuilder()
        .build();
    }

    @Test
    public void all() throws Exception {
        Context context = new ContextBuilder()
                .priority(Priority.REALTIME)
                .place("DE")
                .language("de")
                .writingSystem("Latn:de")
                .textCase(TextCase.TITLE_CASE)
                .property("foo", "bar")
        .build();
        assertEquals(context.getPriority(), Priority.REALTIME);
        assertEquals(context.getWritingSystems().get(0), "Latn:de");
        assertTrue(context.getTextCase().get() == TextCase.TITLE_CASE);
        assertTrue(context.getPlace().isPresent());
        assertEquals(context.getPlace().get(), "DE");
        assertEquals(context.getLanguage().get(), "de");
        assertEquals(context.getContextProperties().getString("foo").get(), "bar");
    }

    @Test
    public void overwriteProperty() throws Exception {
        Context context = new ContextBuilder()
                .priority(Priority.REALTIME)
                .property("foo", "bar")
                .property("foo", "bar2")
        .build();
        assertEquals(context.getContextProperties().getString("foo").get(), "bar2");
    }

    @Test
    public void customProperties() throws Exception {
        Context context = new ContextBuilder()
                .priority(Priority.REALTIME)
                .property("person.name-order", "western:55.436%,eastern:45.0%")
                .property("person.gender", "male:70%,female:30%")
        .build();
        assertEquals(context.getContextProperties().getString("person.name-order").get(), "western:55.436%,eastern:45.0%");
    }
}
