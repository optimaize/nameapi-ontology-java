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
public class InputWithPerson extends ObjectInput {

    @NotNull
    private final InputPerson inputPerson;

    @JsonCreator
    public InputWithPerson(
            @JsonProperty("context") @JsonPropertyDescription("The context defining the caller's environment for the execution.") @Nullable Context context,
            @JsonProperty(value = "inputPerson", required = true) @JsonPropertyDescription("A natural or legal person as used in crm databases, online user databases etc.") @NotNull InputPerson inputPerson
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
    public static InputWithPerson fromString(@NotNull String jsonString) {
        throw new UnsupportedOperationException("This method is only here to comply with swagger requirements.");
    }

}
