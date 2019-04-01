package org.nameapi.ontology5.services.riskdetector;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * One detected risk, as used in a {@link RiskDetectorResult}.
 * There can be 0-n of such risks in one result.
 */
public class DetectedRisk implements Comparable<DetectedRisk> {

    @NotNull
    private final DataItem dataItem;
    @NotNull
    private final RiskType riskType;
    private final double riskScore;
    @NotNull
    private final String reason;

    public DetectedRisk(@JsonProperty("dataItem") @JsonPropertyDescription("Tells which part of the user's input raised the risk alert. See https://goo.gl/kS67Ao for the documentation of the DataItem enum values.") @NotNull DataItem dataItem,
                        @JsonProperty("riskType") @JsonPropertyDescription("<p>Tells what kind of risk was detected. </p>" +
                                "<p>Risk types:" +
                                "<ul>" +
                                "<li>FakeRiskType - classification of fake risks. In some situations the exact classification is difficult. " +
                                "For example a person's name may be from fiction, but also be famous at the same time. See https://goo.gl/2dFKhy</li>" +
                                "<li>DisguiseRiskType - classification of disguise risks. Such mangled input is used to circumvent machine processing. " +
                                "Humans can still understand these modified values, but machines can't unless they detect the patterns and clean " +
                                "the input. See https://goo.gl/zw1kt1</li>" +
                                "</ul></p>") @NotNull RiskType riskType,
                        @JsonProperty("riskScore") @JsonPropertyDescription("The risk score of this data item, range (0,1], the higher the worse.") double riskScore,
                        @JsonProperty("reason") @JsonPropertyDescription("A one sentence text reason that explains the risk for the human.") @NotNull String reason
    ) {
        this.dataItem = dataItem;
        this.riskType = riskType;
        this.riskScore = riskScore;
        this.reason = reason;
    }

    @NotNull
    public DataItem getDataItem() {
        return dataItem;
    }

    @NotNull
    public RiskType getRiskType() {
        return riskType;
    }

    /**
     * @return range (0,1] the higher the worse.
     */
    public double getRiskScore() {
        return riskScore;
    }

    /**
     * A one sentence text reason intended for the human that explains the risk.
     */
    @NotNull
    public String getReason() {
        return reason;
    }

    @Override
    public int compareTo(@NotNull DetectedRisk o) {
        return Double.compare(o.getRiskScore(), getRiskScore());
    }

    @Override
    public String toString() {
        return "FakeDetectorMatch{" +
                "dataItem=" + dataItem +
                ", riskType=" + riskType +
                ", riskScore=" + riskScore +
                ", reason='" + reason + '\'' +
                '}';
    }

}
