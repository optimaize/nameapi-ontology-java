package org.nameapi.ontology5.services.matcher.personmatcher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
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
            @JsonProperty(value = "matchType", required = true) @JsonPropertyDescription("The overall result of the matching.\nSee https://goo.gl/aW7FVo for the documentation of the PersonMatchType enum values.") @NotNull PersonMatchType matchType,
            @JsonProperty(value = "personMatchComposition", required = true) @JsonPropertyDescription("Tells how much the two people have in common.\nSee https://goo.gl/SRpAgM for the documentation of the PersonMatchComposition enum values.") @NotNull PersonMatchComposition personMatchComposition,
            @JsonProperty(value = "points", required = true) @JsonPropertyDescription("A value in the range -1 to 1 that indicates how well the two people match (positive points) or how much they mismatch (negative points).") double points,
            @JsonProperty(value = "confidence", required = true) @JsonPropertyDescription("A value in the range 0-1 that indicates how sure the server is about the result. The higher the better.") double confidence,
            @JsonProperty(value = "personNameMatcherResult", required = true) @JsonPropertyDescription("The result of comparing the names of the 2 people. It contains all possible ways of comparing the name pairs, and offers the best.") @NotNull PersonNameMatcherResult personNameMatcherResult,
            @JsonProperty(value = "genderMatcherResult", required = true) @JsonPropertyDescription("The result of comparing the genders of the 2 people.") @NotNull GenderMatcherResult genderMatcherResult,
            @JsonProperty(value = "ageMatcherResult", required = true) @JsonPropertyDescription("The result of comparing the ages of the 2 people.") @NotNull AgeMatcherResult ageMatcherResult
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
