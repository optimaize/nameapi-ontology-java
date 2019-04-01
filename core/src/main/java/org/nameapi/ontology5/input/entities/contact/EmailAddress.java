package org.nameapi.ontology5.input.entities.contact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

/**
 * Note: vCard says what it is for, work or home. We could add such a property.
 *
 * @author Nicole Torres
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmailAddressImpl.class, name = "EmailAddressImpl")
})
public interface EmailAddress {

    /**
     * @return Not empty. For example "john@example.com".
     */
    @JsonPropertyDescription("The email address, for example \"john@example.com\".")
    @NotNull
    String getEmailAddress();

    @Nullable
    EmailAddress transform(@NotNull ValueTransformer transformer);

}
