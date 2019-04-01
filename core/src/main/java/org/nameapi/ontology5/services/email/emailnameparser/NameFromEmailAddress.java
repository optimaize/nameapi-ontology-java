package org.nameapi.ontology5.services.email.emailnameparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.nameapi.ontology5.cremalang.annotation.GeneratedCode;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.jetbrains.annotations.NotNull;

/**
 * As contained in {@link EmailNameParserMatch}.
 *
 * @author Nicole Torres
 */
@Immutable
public class NameFromEmailAddress {

    @NotNull
    private String name;
    @NotNull
    private EmailAddressNameType nameType;

    @JsonCreator
    public NameFromEmailAddress(
            @JsonProperty("name") @JsonPropertyDescription("The name extracted from the email address.") @NotNull String name,
            @JsonProperty("nameType") @JsonPropertyDescription("What kind of name string it is. See https://goo.gl/2UYPsJ for the documentation of the EmailAddressNameType enum values.") @NotNull EmailAddressNameType nameType
    ) {
        this.name = name;
        this.nameType = nameType;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public EmailAddressNameType getNameType() {
        return nameType;
    }

    @Override @NotNull
    public String toString() {
        return name+"("+nameType+")";
    }


    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameFromEmailAddress name1 = (NameFromEmailAddress) o;

        if (!name.equals(name1.name)) return false;
        if (nameType != name1.nameType) return false;

        return true;
    }

    @Override @GeneratedCode
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + nameType.hashCode();
        return result;
    }
}
