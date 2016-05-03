package org.nameapi.ontology5.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.input.context.Context;
import org.nameapi.ontology5.input.entities.person.InputPerson;

/**
 *
 * @author Nicole Torres
 */
public class InputWithPerson extends ObjectInput {

    @NotNull
    private final InputPerson inputPerson;

    @JsonCreator
    public InputWithPerson(
            @JsonProperty("context") @Nullable Context context,
            @JsonProperty("inputPerson") @NotNull InputPerson inputPerson
    ) {
        super(context);
        this.inputPerson = inputPerson;
    }

    @NotNull
    public InputPerson getInputPerson() {
        return inputPerson;
    }

    @Override
    public String toString() {
        return "InputWithPerson{" +
                "inputPerson=" + inputPerson +
                '}';
    }
}
