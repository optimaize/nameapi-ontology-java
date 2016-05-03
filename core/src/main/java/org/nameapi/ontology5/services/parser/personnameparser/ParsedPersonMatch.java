package org.nameapi.ontology5.services.parser.personnameparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
            @JsonProperty("parsedPerson") ParsedPerson parsedPerson,
            @JsonProperty("parserDisputes") List<ParserDispute> parserDisputes,
            @JsonProperty("likeliness") double likeliness,
            @JsonProperty("confidence") double confidence
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
