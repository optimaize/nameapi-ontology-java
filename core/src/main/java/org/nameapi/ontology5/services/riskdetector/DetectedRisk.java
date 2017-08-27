package org.nameapi.ontology5.services.riskdetector;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    public DetectedRisk(@JsonProperty("dataItem") @NotNull DataItem dataItem,
                        @JsonProperty("fakeMatchType") @NotNull RiskType riskType,
                        @JsonProperty("riskScore") double riskScore,
                        @JsonProperty("reason") @NotNull String reason
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

    public double getRiskScore() {
        return riskScore;
    }

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
