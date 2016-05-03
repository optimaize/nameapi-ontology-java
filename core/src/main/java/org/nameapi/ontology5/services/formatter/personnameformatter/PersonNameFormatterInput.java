package org.nameapi.ontology5.services.formatter.personnameformatter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.input.context.Context;
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.services.InputWithPerson;
import org.nameapi.ontology5.services.formatter.FormatterProperties;

/**
 *
 * @author Fabian Kessler
 */
public class PersonNameFormatterInput extends InputWithPerson {

    @Nullable
    private final FormatterProperties properties;

    @JsonCreator
    public PersonNameFormatterInput(
            @JsonProperty("context") @Nullable Context context,
            @JsonProperty("inputPerson") @NotNull InputPerson inputPerson,
            @JsonProperty("properties") @Nullable FormatterProperties properties
    ) {
        super(context, inputPerson);
        this.properties = properties;
    }

    @Nullable
    public FormatterProperties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "PersonNameFormatterInput{" +
                "properties=" + properties +
                '}';
    }
}
