
package org.nameapi.ontology5.services.matcher.personmatcher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 *
 * @author Fabian Kessler
 */
public class PersonNameMatcherResult {

    private final PersonNameMatchType matchType;

    @JsonCreator
    public PersonNameMatcherResult(
            @JsonProperty("matchType") @JsonPropertyDescription("The overall match type of how the names of one person match vs the names of another person." +
                    "\nSee https://goo.gl/iDDBom for the documentation of the PersonNameMatchType enum values.") PersonNameMatchType matchType)
    {
        this.matchType = matchType;
    }

    public PersonNameMatchType getMatchType() {
        return matchType;
    }

    @Override
    public String toString() {
        return "PersonNameMatcherResult{" +
                "matchType=" + matchType +
                '}';
    }
}
