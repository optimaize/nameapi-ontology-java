package org.nameapi.ontology5.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.input.context.Context;
import org.nameapi.ontology5.input.entities.person.InputPerson;

/**
 *
 * @author Nicole Torres
 */
public class InputWithTwoPeople extends ObjectInput {

    @NotNull
    private final InputPerson inputPerson1;
    @NotNull
    private final InputPerson inputPerson2;

    @JsonCreator
    public InputWithTwoPeople(
            @JsonProperty("context") @JsonPropertyDescription("The context defining the caller's environment for the execution.") @Nullable Context context,
            @JsonProperty("inputPerson1") @NotNull InputPerson inputPerson1,
            @JsonProperty("inputPerson2") @NotNull InputPerson inputPerson2
    ) {
        super(context);
        this.inputPerson1 = inputPerson1;
        this.inputPerson2 = inputPerson2;
    }

    @NotNull
    public InputPerson getInputPerson1() {
        return inputPerson1;
    }

    @NotNull
    public InputPerson getInputPerson2() {
        return inputPerson2;
    }

    @Override
    public String toString() {
        return "InputWithTwoPeople{" +
                "inputPerson1=" + inputPerson1 +
                ", inputPerson2=" + inputPerson2 +
                '}';
    }

    /**
     * Not used, always throws!
     *
     * An actual implementation using Jackson could be:
     * <pre>
     *          ObjectMapper mapper = new ObjectMapper();
     *          try {
     *              return mapper.readValue(jsonRepresentation, InputWithEmail.class );
     *          } catch (IOException e) {
     *              throw new IllegalArgumentException("The json is not a valid representation of the object: \n" + jsonString);
     *         }
     * </pre>
     *
     * @throws UnsupportedOperationException This method is only here to comply with swagger server-side API requirements.
     */
    @NotNull
    public static InputWithTwoPeople fromString(@NotNull String jsonString) {
        throw new UnsupportedOperationException("This method is only here to comply with swagger requirements.");
    }
}
