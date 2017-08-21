package org.nameapi.ontology5.input.entities.contact;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

/**
 * Simple implementation of a plain email address.
 *
 * <p>Code example:
 * <code>EmailAddress emailAddress = new EmailAddressImpl("john@example.com");</code>
 * </p>
 *
 * @author Nicole Torres
 */
final class EmailAddressImpl implements EmailAddress {

    @NotNull
    private final String emailAddress;

    /**
     * @param emailAddress Not empty. For example "john@example.com".
     */
    public EmailAddressImpl(@JsonProperty("emailAddress") @NotNull String emailAddress) {
        if (emailAddress.isEmpty()) {
            throw new IllegalArgumentException("Email address may not be empty!");
        }
        this.emailAddress = emailAddress;
    }

    @NotNull @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Nullable
    @Override
    public EmailAddress transform(@NotNull ValueTransformer transformer) {
        String modified = transformer.transform(emailAddress);
        if (modified==null || modified.isEmpty()) return null;
        if (emailAddress.equals(modified)) return this;
        return new EmailAddressImpl(modified);
    }


    @Override
    public String toString() {
        return "EmailAddressImpl{" +
                "emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailAddressImpl that = (EmailAddressImpl) o;

        if (!emailAddress.equals(that.emailAddress)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return emailAddress.hashCode();
    }
}
