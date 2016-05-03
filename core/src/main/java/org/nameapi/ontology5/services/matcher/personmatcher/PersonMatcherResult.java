package org.nameapi.ontology5.services.matcher.personmatcher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @author Fabian Kessler
 */
public class PersonMatcherResult {

    @NotNull
    private final PersonMatchType matchType;

    @NotNull
    private final PersonMatchComposition personMatchComposition;

    private final double points;

    private final double confidence;


    @NotNull
    private final PersonNameMatcherResult personNameMatcherResult;

    @NotNull
    private final GenderMatcherResult genderMatcherResult;

    @NotNull
    private final AgeMatcherResult ageMatcherResult;


    @JsonCreator
    public PersonMatcherResult(
            @JsonProperty("matchType") @NotNull PersonMatchType matchType,
            @JsonProperty("personMatchComposition") @NotNull PersonMatchComposition personMatchComposition,
            @JsonProperty("points") double points,
            @JsonProperty("confidence") double confidence,
            @JsonProperty("personNameMatcherResult") @NotNull PersonNameMatcherResult personNameMatcherResult,
            @JsonProperty("genderMatcherResult") @NotNull GenderMatcherResult genderMatcherResult,
            @JsonProperty("ageMatcherResult") @NotNull AgeMatcherResult ageMatcherResult
    ) {
        this.matchType = matchType;
        this.personMatchComposition = personMatchComposition;
        this.points = points;
        this.confidence = confidence;
        this.personNameMatcherResult = personNameMatcherResult;
        this.genderMatcherResult = genderMatcherResult;
        this.ageMatcherResult = ageMatcherResult;
    }

    @NotNull
    public PersonMatchType getMatchType() {
        return matchType;
    }

    @NotNull
    public PersonMatchComposition getPersonMatchComposition() {
        return personMatchComposition;
    }

    public double getPoints() {
        return points;
    }

    public double getConfidence() {
        return confidence;
    }

    @NotNull
    public PersonNameMatcherResult getPersonNameMatcherResult() {
        return personNameMatcherResult;
    }

    @NotNull
    public GenderMatcherResult getGenderMatcherResult() {
        return genderMatcherResult;
    }

    @NotNull
    public AgeMatcherResult getAgeMatcherResult() {
        return ageMatcherResult;
    }

    @Override
    public String toString() {
        return "PersonMatcherResult{" +
                "matchType=" + matchType +
                ", personMatchComposition=" + personMatchComposition +
                ", points=" + points +
                ", confidence=" + confidence +
                ", personNameMatcherResult=" + personNameMatcherResult +
                ", genderMatcherResult=" + genderMatcherResult +
                ", ageMatcherResult=" + ageMatcherResult +
                '}';
    }
}
