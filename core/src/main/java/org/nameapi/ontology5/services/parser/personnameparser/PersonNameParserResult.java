package org.nameapi.ontology5.services.parser.personnameparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.List;

/**
 * @author Fabian Kessler
 * @author Nicole Torres
 */
public class PersonNameParserResult {

    private final List<ParsedPersonMatch> matches;

    @JsonCreator
    public PersonNameParserResult(
            @JsonProperty("matches") @JsonPropertyDescription("A list of possible ways how a person could be parsed.\n" +
                    "The entries are sorted by likeliness & confidence, the first is the best parsing result.") List<ParsedPersonMatch> matches
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
