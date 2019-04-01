package org.nameapi.ontology5.services.parser.personnameparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.List;

/**
 * @author Fabian Kessler
 * @author Nicole Torres
 */
public class ParsedPersonMatch {

    private final ParsedPerson parsedPerson;
    private final List<ParserDispute> parserDisputes;
    private final double likeliness;
    private final double confidence;

    @JsonCreator
    public ParsedPersonMatch(
            @JsonProperty("parsedPerson") @JsonPropertyDescription("Information about the person: the computed gender, the addressing given name, the addressing surname...") ParsedPerson parsedPerson,
            @JsonProperty("parserDisputes") @JsonPropertyDescription("A list of consistency problems detected by the parser is within this object.") List<ParserDispute> parserDisputes,
            @JsonProperty("likeliness") @JsonPropertyDescription("A value in the range 0-1 that indicates how likely is it that this is the correct way of parsing. The higher the better.") double likeliness,
            @JsonProperty("confidence") @JsonPropertyDescription("A value in the range 0-1 that indicates how sure the server is about the result. The higher the better.") double confidence
    ) {
        this.parsedPerson = parsedPerson;
        this.parserDisputes = parserDisputes;
        this.likeliness = likeliness;
        this.confidence = confidence;
    }


    public ParsedPerson getParsedPerson() {
        return parsedPerson;
    }

    public List<ParserDispute> getParserDisputes() {
        return parserDisputes;
    }

    public double getLikeliness() {
        return likeliness;
    }

    public double getConfidence() {
        return confidence;
    }

    @Override
    public String toString() {
        return "ParsedPersonMatch{" +
                "parsedPerson=" + parsedPerson +
                ", nameParserDisputes=" + parserDisputes +
                ", likeliness=" + likeliness +
                ", confidence=" + confidence +
                '}';
    }
}
