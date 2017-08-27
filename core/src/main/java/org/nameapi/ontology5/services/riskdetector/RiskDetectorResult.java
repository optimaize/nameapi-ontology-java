package org.nameapi.ontology5.services.riskdetector;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.cremalang.annotation.Immutable;

import java.util.List;

/**
 * The result returned by the OverallRiskDetectorImpl
 */
@Immutable
public class RiskDetectorResult {

    private final double score;

    @NotNull
    private final List<DetectedRisk> risks;

    @JsonCreator
    public RiskDetectorResult(
            @JsonProperty("score") double score,
            @JsonProperty("risks") @NotNull List<DetectedRisk> risks
    ) {
        if (score < -1 || score > 1) throw new IllegalArgumentException("Score was out of range: "+score);
        this.score = score;
        this.risks = ImmutableList.copyOf(risks);
    }

    /**
     * An overall score considering all the detected risks and all the positive attributes of the record.
     *
     * Range [-1,0) means no risks were detected and the record looks good.
     * 0 means no risks were detected, but also no positive attributes were found, the service can't tell for sure.
     * Range (0,1] means one or multiple  risks were detected.
     *
     * @return Range [-1,1]
     */
    public double getScore() {
        return score;
    }

    @JsonIgnore
    public boolean hasRisk() {
        return !risks.isEmpty();
    }

    /**
     * @return The risk with the highest score, if any.
     */
    @NotNull @JsonIgnore
    public Optional<DetectedRisk> getWorstRisk() {
        if (risks.isEmpty()) return Optional.absent();
        return Optional.of(risks.get(0));
    }

    /**
     * Returns all the detected risks.
     * @return Sorted by severity having the worst come first.
     *         Possibly empty, guaranteed to be non-empty if the getScore() is > 0. Immutable.
     */
    @NotNull
    public List<DetectedRisk> getRisks() {
        return risks;
    }

    @Override
    public String toString() {
        return "RiskDetectorResult{" +
                "score=" + score +
                ", detectedRisks=" + risks +
                '}';
    }

}
