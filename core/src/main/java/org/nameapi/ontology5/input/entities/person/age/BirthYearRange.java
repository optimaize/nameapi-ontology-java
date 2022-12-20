package org.nameapi.ontology5.input.entities.person.age;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.google.common.base.Optional;
import org.nameapi.ontology5.cremalang.annotation.GeneratedCode;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

/**
 * An implementation of AgeInfo that knows just a year range, for example 1970-1989.
 *
 * @author sam
 */
@Immutable
final class BirthYearRange implements AgeInfo {

    @NotNull
    private final YearRange yearRange;

    @JsonCreator
    public BirthYearRange(
            @JsonProperty("yearStartIncl") @JsonPropertyDescription("4-digit start year including")@Nullable Integer yearStartIncl,
            @JsonProperty("yearEndIncl") @JsonPropertyDescription(("4-digit end year including")) @Nullable Integer yearEndIncl) {
        if (yearStartIncl!=null) {
            AgeUtil.checkYear(yearStartIncl);
        }
        if (yearEndIncl!=null) {
            AgeUtil.checkYear(yearEndIncl);
        }
        if (yearStartIncl!=null && yearEndIncl!=null) {
            if (yearStartIncl > yearEndIncl) {
                throw new IllegalArgumentException("Year end may not be before year start but it was: start="+yearStartIncl+" end="+yearEndIncl+"!");
            }
        }
        this.yearRange = YearRange.forRange(Optional.fromNullable(yearStartIncl), Optional.fromNullable(yearEndIncl));
    }


    @NotNull @Override
    public Optional<Integer> getYear() {
        if (isStartAndEndPresentAndEqual()) {
            return yearRange.getStartIncluding();
        }
        return Optional.absent();
    }

    private boolean isStartAndEndPresentAndEqual() {
        if (!yearRange.getStartIncluding().isPresent()) return false;
        if (!yearRange.getEndIncluding().isPresent()) return false;
        return yearRange.getStartIncluding().get().equals( yearRange.getEndIncluding().get() );
    }

    @NotNull @Override
    public Optional<Integer> getMonth() {
        return Optional.absent();
    }
    @NotNull @Override
    public Optional<Integer> getDay() {
        return Optional.absent();
    }

    @NotNull @Override
    public YearRange getYearRange() {
        return yearRange;
    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return yearRange.isEmpty();
    }

    @Nullable
    @Override
    public AgeInfo transform(@NotNull ValueTransformer transformer) {
        return this;
    }


    @Override
    public String toString() {
        return "BirthYearRange{" +yearRange+'}';
    }


    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BirthYearRange that = (BirthYearRange) o;

        if (!yearRange.equals(that.yearRange)) return false;

        return true;
    }

    @Override @GeneratedCode
    public int hashCode() {
        return yearRange.hashCode();
    }
}
