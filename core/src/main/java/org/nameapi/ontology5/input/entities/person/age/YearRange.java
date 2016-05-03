package org.nameapi.ontology5.input.entities.person.age;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import org.nameapi.ontology5.cremalang.annotation.GeneratedCode;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.jetbrains.annotations.NotNull;

/**
 * A from-to year range as used by {@link AgeInfo#getYearRange()}.
 */
@Immutable
public class YearRange {

    private static final YearRange EMPTY = new YearRange(Optional.<Integer>absent(), Optional.<Integer>absent());

    /**
     * @return The start year, for example 1980. Absent if not known.
     */
    @NotNull
    private final Optional<Integer> startIncluding;
    /**
     * @return The end year, for example 1989. Absent if not known.
     */
    @NotNull
    private final Optional<Integer> endIncluding;

    public static YearRange empty() {
        return EMPTY;
    }
    public static YearRange forRange(@NotNull Optional<Integer> startIncluding, @NotNull Optional<Integer> endIncluding) {
        if (!startIncluding.isPresent() && !endIncluding.isPresent()) return empty();
        return new YearRange(startIncluding, endIncluding);
    }

    @JsonCreator
    private YearRange(
            @JsonProperty("startIncluding") @NotNull Optional<Integer> startIncluding,
            @JsonProperty("endIncluding") @NotNull Optional<Integer> endIncluding
    ) {
        if (startIncluding.isPresent() && startIncluding.get() < 0) {
            throw new IllegalArgumentException("Start is out of permitted range: "+startIncluding.get());
        }
        if (endIncluding.isPresent() && endIncluding.get() > 2100) {
            throw new IllegalArgumentException("End is out of permitted range: "+endIncluding.get());
        }
        if (startIncluding.isPresent() && endIncluding.isPresent() && (startIncluding.get() > endIncluding.get())) {
            throw new IllegalArgumentException("End cannot be smaller than start: "+startIncluding.get()+"/"+endIncluding.get());
        }
        this.startIncluding = startIncluding;
        this.endIncluding = endIncluding;
    }

    @NotNull
    public Optional<Integer> getStartIncluding() {
        return startIncluding;
    }

    @NotNull
    public Optional<Integer> getEndIncluding() {
        return endIncluding;
    }

    /**
     * @return {@code true} if both {@link #getStartIncluding()} and {@link #getEndIncluding()} are {@code absent}.
     */
    @JsonIgnore
    public boolean isEmpty() {
        if (startIncluding.isPresent()) return false;
        if (endIncluding.isPresent()) return false;
        return true;
    }


    @Override
    public String toString() {
        return "YearRange[" +startIncluding.orNull() +"/"+endIncluding.orNull() +'}';
    }


    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YearRange yearRange = (YearRange) o;

        if (!endIncluding.equals(yearRange.endIncluding)) return false;
        if (!startIncluding.equals(yearRange.startIncluding)) return false;

        return true;
    }

    @Override @GeneratedCode
    public int hashCode() {
        int result = startIncluding.hashCode();
        result = 31 * result + endIncluding.hashCode();
        return result;
    }

}
