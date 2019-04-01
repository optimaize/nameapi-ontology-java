package org.nameapi.ontology5.services.matcher.personmatcher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 */
public class TelNumberMatcherResult {

    private final TelNumberMatchType matchType;

    @JsonCreator
    public TelNumberMatcherResult(
            @JsonProperty("matchType") @JsonPropertyDescription("Tells how two phone numbers match.") TelNumberMatchType matchType)
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
