
package org.nameapi.ontology5.services.matcher.personmatcher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
 *
 * @author Fabian Kessler
 */
public class GenderMatcherResult {

    @NotNull
    private final GenderMatchType matchType;
    private final double confidence;
    @NotNull
    private final List<String> warnings;

    @JsonCreator
    public GenderMatcherResult(
            @JsonProperty("matchType") @JsonPropertyDescription("Tells how the 2 genders matched. See https://goo.gl/iJQSBf for the documentation of the GenderMatchType enum values.") @NotNull GenderMatchType matchType,
            @JsonProperty("confidence") @JsonPropertyDescription("A value in the range 0-1 that indicates how sure the server is about the result. The higher the better.") double confidence,
            @JsonProperty("warnings") @JsonPropertyDescription("Messages describing possible problems that were identified.") @NotNull List<String> warnings
    ) {
        this.matchType = matchType;
        this.confidence = confidence;
        this.warnings = warnings;
    }

    @NotNull
    public GenderMatchType getMatchType() {
        return matchType;
    }

    public double getConfidence() {
        return confidence;
    }

    @NotNull
    public List<String> getWarnings() {
        return warnings;
    }

    @Override
    public String toString() {
        return "GenderMatcherResult{" +
                "matchType=" + matchType +
                ", confidence=" + confidence +
                ", warnings=" + warnings +
                '}';
    }
}
