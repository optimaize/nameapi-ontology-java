package org.nameapi.ontology5.services.matcher.personmatcher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Fabian Kessler
 */
public class AgeMatcherResult {

    private final AgeMatchType matchType;

    @JsonCreator
    public AgeMatcherResult(
            @JsonProperty("matchType") AgeMatchType matchType
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
