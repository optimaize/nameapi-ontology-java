package org.nameapi.ontology5.input.entities.person.age;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

/**
 * Impl of AgeInfo that doesn't contain any information.
 *
 * @author sam
 */
final class NullAgeInfo implements AgeInfo {

    private static final NullAgeInfo INSTANCE = new NullAgeInfo();

    @NotNull
    public static NullAgeInfo getInstance() {
        return INSTANCE;
    }

    @JsonCreator
    private NullAgeInfo() {
    }


    @NotNull @Override
    public Optional<Integer> getYear() {
        return Optional.absent();
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
        return YearRange.empty();
    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return true;
    }

    @Nullable
    @Override
    public AgeInfo transform(@NotNull ValueTransformer transformer) {
        return this;
    }

    @Override
    public String toString() {
        return "NullAgeInfo";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        //nothing to override.
        return super.hashCode();
    }

}
