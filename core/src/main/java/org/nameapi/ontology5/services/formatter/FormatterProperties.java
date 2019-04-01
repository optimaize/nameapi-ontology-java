package org.nameapi.ontology5.services.formatter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * The properties will be defined in a future version.
 * There are many options how it could be implemented, no decision has been made yet.
 *
 * @author Fabian Kessler
 */
public class FormatterProperties {

    private final boolean dummy;

    @JsonCreator
    public FormatterProperties(
            @JsonProperty("dummy") @JsonPropertyDescription("The properties will be defined in a future version. There are many options how it could be implemented, no decision has been made yet.") boolean dummy)
    {
        this.dummy = dummy;
    }

    public boolean isDummy() {
        return dummy;
    }
}
