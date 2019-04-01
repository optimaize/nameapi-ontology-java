package org.nameapi.ontology5.services.matcher.personmatcher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * @author Fabian Kessler
 */
public class AgeMatcherResult {

    private final AgeMatchType matchType;

    @JsonCreator
    public AgeMatcherResult(
            @JsonProperty("matchType") @JsonPropertyDescription("Tells how two ages match.\nSee https://goo.gl/J5h3sv for the documentation of the AgeMatchType enum values.") AgeMatchType matchType
    ) {
        this.matchType = matchType;
    }

    public AgeMatchType getMatchType() {
        return matchType;
    }

    @Override
    public String toString() {
        return "AgeMatcherResult{" +
                "matchType=" + matchType +
                '}';
    }
}
