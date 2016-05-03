package org.nameapi.ontology5.services.email.emailnameparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * One successful way of parsing a name out of an email address.
 *
 * @author Nicole Torres
 */
@Immutable
public final class EmailNameParserMatch {

    @NotNull
    private final List<NameFromEmailAddress> givenNames;
    @NotNull
    private final List<NameFromEmailAddress> surnames;

    private final double confidence;

    @JsonCreator
    public EmailNameParserMatch(
            @JsonProperty("givenNames") @NotNull List<NameFromEmailAddress> givenNames,
            @JsonProperty("surnames") @NotNull List<NameFromEmailAddress> surnames,
            @JsonProperty("confidence") double confidence
    ) {
        this.givenNames = Collections.unmodifiableList(givenNames);
        this.surnames   = Collections.unmodifiableList(surnames);
        this.confidence = confidence;
    }

    @NotNull
    public List<NameFromEmailAddress> getGivenNames() {
        return givenNames;
    }

    @NotNull
    public List<NameFromEmailAddress> getSurnames() {
        return surnames;
    }

    public double getConfidence() {
        return confidence;
    }

    @Override
    public String toString() {
        return "EmailNameExtractingMatch{" +
                "givenNames=" + givenNames +
                ", surnames=" + surnames +
                ", confidence=" + confidence +
                '}';
    }
}
