package org.nameapi.ontology5.services.matcher.personmatcher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
public class TelNumberMatcherResult {

    private final TelNumberMatchType matchType;

    @JsonCreator
    public TelNumberMatcherResult(
            @JsonProperty("matchType") TelNumberMatchType matchType)
    {
        this.matchType = matchType;
    }

    public TelNumberMatchType getMatchType() {
        return matchType;
    }

    @Override
    public String toString() {
        return "PhoneNumberMatchType{" +
                "matchType=" + matchType +
                '}';
    }

}
