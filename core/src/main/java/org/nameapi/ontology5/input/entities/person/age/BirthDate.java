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

import java.util.Date;

/**
 * An implementation of AgeInfo that knows all fields.
 *
 * @author sam
 */
@Immutable
final class BirthDate implements AgeInfo {

    private final int year;
    private final int month;
    private final int day;

    /**
     * Example: new BirthDate("1986", "12", "31");
     * @param year 4-digit year
     * @param month 1-2-digit month from 1-12
     * @param day 1-2-digit day from 1-31
     */
    public BirthDate(
            @NotNull String year,
            @NotNull String month,
            @NotNull String day
    ) throws IllegalArgumentException {
        this(Integer.parseInt(year,10), Integer.parseInt(month,10), Integer.parseInt(day,10));
    }
    @SuppressWarnings("ConstantConditions")
    public BirthDate(@NotNull Date date) {
        //noinspection deprecation
        this(date.getYear()+1900, date.getMonth()+1, date.getDate());
    }
    /**
     * Example: new BirthDate(1986, 12, 31);
     * @param year 4-digit year
     * @param month 1-2-digit month from 1-12
     * @param day 1-2-digit day from 1-31
     */
    @JsonCreator
    public BirthDate(
            @JsonProperty("year") @JsonPropertyDescription("4-digit year") int year,
            @JsonProperty("month") @JsonPropertyDescription("1-2-digit month from 1-12") int month,
            @JsonProperty("day") @JsonPropertyDescription("1-2-digit day from 1-31") int day
    ) {
        if (year<1  || year>2100) throw new IllegalArgumentException("Year is out of legal range: "+year+"!");
        if (month<1 || month>12)  throw new IllegalArgumentException("Month must be 1-12 but was: "+month+"!");
        if (day<1   || day>31)    throw new IllegalArgumentException("Day must be 1-31 but was: "+day+"!");
        //noinspection deprecation
        this.year  = year;
        this.month = month;
        this.day   = day;
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
        return Optional.of(day);
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
        return "BirthDate["+year + "-"+zeroPad(month)+"-"+zeroPad(day)+"]";
    }
    private String zeroPad(int i) {
        if (i>9) return ""+i;
        return "0"+i;
    }

    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BirthDate birthDate = (BirthDate) o;

        if (day != birthDate.day) return false;
        if (month != birthDate.month) return false;
        if (year != birthDate.year) return false;

        return true;
    }

    @Override @GeneratedCode
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        return result;
    }
}
