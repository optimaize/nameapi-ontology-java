package org.nameapi.ontology5.services.parser.personnameparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Fabian Kessler
 * @author Nicole Torres
 */
public class PersonNameParserResult {

    private final List<ParsedPersonMatch> matches;

    @JsonCreator
    public PersonNameParserResult(
            @JsonProperty("matches") List<ParsedPersonMatch> matches
    ) {
        if (matches.isEmpty()) throw new IllegalArgumentException("At least one match is required!");
        this.matches = matches;
    }

    /**
     * @return not empty.
     */
    public List<ParsedPersonMatch> getMatches() {
        return matches;
    }

    @JsonIgnore
    public ParsedPersonMatch getBestMatch() {
        return matches.get(0);
    }

    @Override
    public String toString() {
        return "PersonNameParserResult{" +
                "matches=" + matches +
                '}';
    }
}
