package org.nameapi.ontology5.input.entities.person.age;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

/**
 * Creates {@link AgeInfo} instances.
 *
 * @author aa
 */
public class AgeInfoFactory {

    public static AgeInfo forEmpty() {
        return NullAgeInfo.getInstance();
    }

    public static AgeInfo forDate(@NotNull java.util.Date date) {
        return new BirthDate(date);
    }
    /**
     * Example: new BirthDate(1986, 12, 31);
     * @param year 4-digit year
     * @param month 1-2-digit month from 1-12
     * @param day 1-2-digit day from 1-31
     */
    public static AgeInfo forDate(int year, int month, int day) {
        return new BirthDate(year, month, day);
    }
    /**
     * @see #forDate(int, int, int)
     */
    public static AgeInfo forDate(@NotNull String year, @NotNull String month, @NotNull String day) {
        return new BirthDate(year, month, day);
    }

    public static AgeInfo forYearAndMonth(int year, int month) {
        return new BirthYearMonth(year, month);
    }

    public static AgeInfo forYear(int year) {
        return new BirthYear(year);
    }

    public static AgeInfo forYearRange(int yearStartIncl, int yearEndIncl) {
        return new BirthYearRange(yearStartIncl, yearEndIncl);
    }
    public static AgeInfo forYearRangeStart(int yearStartIncl) {
        return new BirthYearRange(yearStartIncl, null);
    }
    public static AgeInfo forYearRangeEnd(int yearEndIncl) {
        return new BirthYearRange(null, yearEndIncl);
    }

    public static AgeInfo forAgeRange(int minimalAge, int maximalAge) {
        verifyAgeValue(minimalAge);
        verifyAgeValue(maximalAge);
        if (minimalAge > maximalAge) throw new IllegalArgumentException("Minimal age cannot be larger than maximal age: "+minimalAge+"/"+maximalAge+"!");
        int startYearIncl = computeStartYearIncl(maximalAge);
        int endYearIncl = computeEndYearIncl(minimalAge);
        return forYearRange(startYearIncl, endYearIncl);
    }
    public static AgeInfo forMinimalAge(int minimalAge) {
        verifyAgeValue(minimalAge);
        int endYearIncl = computeEndYearIncl(minimalAge);
        return forYearRangeEnd(endYearIncl);
    }
    public static AgeInfo forMaximalAge(int maximalAge) {
        verifyAgeValue(maximalAge);
        int startYearIncl = computeStartYearIncl(maximalAge);
        return forYearRangeStart(startYearIncl);
    }

    private static int computeStartYearIncl(int maximalAge) {
        return getCurrentYear() - maximalAge;
    }
    private static int computeEndYearIncl(int minimalAge) {
        return getCurrentYear() - minimalAge;
    }

    private static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    private static void verifyAgeValue(int minOrMaxAge) {
        if (minOrMaxAge < 0) throw new IllegalArgumentException("May not be smaller than 0: "+minOrMaxAge);
        if (minOrMaxAge > 150) throw new IllegalArgumentException("May not be larger than 150: "+minOrMaxAge);
    }

}
