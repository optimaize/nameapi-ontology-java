package org.nameapi.ontology5.services.formatter.personnameformatter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.input.context.Context;
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.input.entities.person.LegalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
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
            @JsonProperty("context") @JsonPropertyDescription("The context defining the caller's environment for the execution.") @Nullable Context context,
            @JsonProperty("inputPerson") @JsonPropertyDescription("A natural or legal person as used in crm databases, online user databases etc.") @NotNull InputPerson inputPerson,
            @JsonProperty("properties") @JsonPropertyDescription("The properties will be defined in a future version. There are many options how it could be implemented, no decision has been made yet.") @Nullable FormatterProperties properties
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
