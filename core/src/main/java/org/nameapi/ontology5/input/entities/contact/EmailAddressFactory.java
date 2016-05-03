package org.nameapi.ontology5.input.entities.contact;

import org.jetbrains.annotations.NotNull;

/**
 * Factory for making {@link org.nameapi.ontology5.input.entities.contact.EmailAddress} instances.
 *
 * @author Nicole Torres
 */
public class EmailAddressFactory {

    /**
     * @param email A single email address, for example "john@example.com"
     */
    @NotNull
    public static EmailAddress forAddress(@NotNull String email) {
        return new EmailAddressImpl(email);
    }

}
