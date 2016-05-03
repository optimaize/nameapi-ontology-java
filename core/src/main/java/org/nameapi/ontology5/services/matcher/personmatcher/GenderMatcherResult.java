
package org.nameapi.ontology5.services.matcher.personmatcher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
            @JsonProperty("matchType") @NotNull GenderMatchType matchType,
            @JsonProperty("confidence") double confidence,
            @JsonProperty("warnings") @NotNull List<String> warnings
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
