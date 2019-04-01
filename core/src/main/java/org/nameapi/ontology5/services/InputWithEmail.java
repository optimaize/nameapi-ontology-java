package org.nameapi.ontology5.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.input.context.Context;

/**
 *
 * @author Nicole Torres
 */
public class InputWithEmail extends ObjectInput {

    @NotNull
    private final String emailAddress;

    @JsonCreator
    public InputWithEmail(
            @JsonProperty("context") @JsonPropertyDescription("The context defining the caller's environment for the execution.") @Nullable Context context,
            @JsonProperty(value = "emailAddress", required = true) @JsonPropertyDescription("The email address, for example \"test@example.com\".") @NotNull String emailAddress
    ) {
        super(context);
        this.emailAddress = emailAddress;
    }

    @NotNull
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "InputWithEmail{" +
                "emailAddress='" + emailAddress + '\'' +
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
    public static InputWithEmail fromString(@NotNull String jsonString) {
        throw new UnsupportedOperationException("This method is only here to comply with swagger server-side API requirements.");
    }

}
