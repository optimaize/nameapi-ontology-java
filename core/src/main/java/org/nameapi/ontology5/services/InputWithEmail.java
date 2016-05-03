package org.nameapi.ontology5.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
            @JsonProperty("context") @Nullable Context context,
            @JsonProperty("emailAddress") @NotNull String emailAddress
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
}
