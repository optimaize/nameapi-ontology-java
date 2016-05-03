package org.nameapi.ontology5.services.genderizer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.cremalang.annotation.GeneratedCode;
import org.nameapi.ontology5.input.entities.person.gender.ComputedPersonGender;

/**
 * @author Fabian Kessler
 */
public final class GenderizerResult {

    @NotNull
    private final ComputedPersonGender gender;

    /**
     * If neutral (otherwise <code>absent</code>) then this may be specified (but does not have to be),
     * 0-1, the remaining % are for female.
     */
    @NotNull
    private final Optional<Double> maleProportion;

    /**
     * 0-1 where 1 is the best.
     */
    private final double confidence;

    @JsonCreator
    public GenderizerResult(
            @JsonProperty("gender") @NotNull ComputedPersonGender gender,
            @JsonProperty("maleProportion") @NotNull Optional<Double> maleProportion,
            @JsonProperty("confidence") double confidence
    ) {
        this.gender = gender;
        this.maleProportion = maleProportion;
        this.confidence = confidence;
    }


    @NotNull
    public ComputedPersonGender getGender() {
        return gender;
    }

    @NotNull
    public Optional<Double> getMaleProportion() {
        return maleProportion;
    }

    public double getConfidence() {
        return confidence;
    }


    @Override
    public String toString() {
        String ret = "GenderResult{" +
                "gender=" + gender;
        if (!gender.isClear() && gender.hasGenderInfo() && maleProportion.isPresent()) {
            ret += ", maleProportion=" + maleProportion;
        }
        ret += ", confidence=" + confidence +'}';
        return ret;
    }


    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenderizerResult that = (GenderizerResult) o;

        if (Double.compare(that.confidence, confidence) != 0) return false;
        if (gender != that.gender) return false;
        return maleProportion.equals(that.maleProportion);

    }
    @Override @GeneratedCode
    public int hashCode() {
        int result;
        long temp;
        result = gender.hashCode();
        result = 31 * result + maleProportion.hashCode();
        temp = Double.doubleToLongBits(confidence);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
