package org.nameapi.ontology5.input.entities.person.age;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import org.nameapi.ontology5.cremalang.annotation.GeneratedCode;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

/**
 * An implementation of AgeInfo that knows just the year.
 *
 * @author sam
 */
@Immutable
final class BirthYear implements AgeInfo {

    private final int year;

    @JsonCreator
    public BirthYear(
            @JsonProperty("year") int year
    ) {
        AgeUtil.checkYear(year);
        this.year = year;
    }

    @NotNull @Override
    public Optional<Integer> getYear() {
        return Optional.of(year);
    }
    @NotNull @Override
    public Optional<Integer> getMonth() {
        return Optional.absent();
    }
    @NotNull @Override
    public Optional<Integer> getDay() {
        return Optional.absent();
    }

    @JsonIgnore
    @NotNull @Override
    public YearRange getYearRange() {
        return YearRange.forRange(Optional.of(year), Optional.of(year));
    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return false;
    }

    @Nullable
    @Override
    public AgeInfo transform(@NotNull ValueTransformer transformer) {
        return this;
    }


    @Override
    public String toString() {
        return "BirthYear[" +year + ']';
    }


    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BirthYear birthYear = (BirthYear) o;

        if (year != birthYear.year) return false;

        return true;
    }

    @Override @GeneratedCode
    public int hashCode() {
        return year;
    }
}
