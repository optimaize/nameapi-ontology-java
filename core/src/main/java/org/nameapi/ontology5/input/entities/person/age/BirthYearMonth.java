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
 * An implementation of AgeInfo that knows the year and the month.
 *
 * @author sam
 */
@Immutable
final class BirthYearMonth implements AgeInfo {

    private final int year;
    private final int month;

    /**
     * Example: new BirthYearMonth("1986", "12");
     * @param year 4-digit year
     * @param month 1-2-digit month from 1-12
     */
    public BirthYearMonth(@NotNull String year, @NotNull String month) throws IllegalArgumentException {
        this(Integer.parseInt(year,10), Integer.parseInt(month,10));
    }
    /**
     * Example: new BirthDate(1986, 12);
     * @param year 4-digit year
     * @param month 1-2-digit month from 1-12
     */
    @JsonCreator
    public BirthYearMonth(
            @JsonProperty("year") @JsonPropertyDescription("4-digit year")  int year,
            @JsonProperty("month") @JsonPropertyDescription("1-2-digit month from 1-12") int month
    ) {
        if (year<0  || year>2100) throw new IllegalArgumentException("Year is out of legal range: "+year+"!");
        if (month<1 || month>12)  throw new IllegalArgumentException("Month must be 1-12 but was: "+month+"!");
        this.year  = year;
        this.month = month;
    }


    @NotNull @Override
    public Optional<Integer> getYear() {
        return Optional.of(year);
    }
    @NotNull @Override
    public Optional<Integer> getMonth() {
        return Optional.of(month);
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
        return "BirthYearMonth["+year + "-"+zeroPad(month)+"]";
    }
    private String zeroPad(int i) {
        if (i>9) return ""+i;
        return "0"+i;
    }

    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BirthYearMonth that = (BirthYearMonth) o;

        if (month != that.month) return false;
        if (year != that.year) return false;

        return true;
    }

    @Override @GeneratedCode
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        return result;
    }
}
