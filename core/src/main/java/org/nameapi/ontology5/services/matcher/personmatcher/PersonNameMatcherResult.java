
package org.nameapi.ontology5.services.matcher.personmatcher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Fabian Kessler
 */
public class PersonNameMatcherResult {

    private final PersonNameMatchType matchType;

    @JsonCreator
    public PersonNameMatcherResult(
            @JsonProperty("matchType") PersonNameMatchType matchType)
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
