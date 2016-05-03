package org.nameapi.ontology5.input.entities.person.age;

import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

import static org.testng.Assert.*;

/**
 * @author Nicole Torres
 */
public class AgeInfoFactoryTest {

    @Test
    public void testForEmpty() throws Exception {
        AgeInfo ageInfo = AgeInfoFactory.forEmpty();
        assertTrue(ageInfo.isEmpty());
        assertFalse(ageInfo.getYear().isPresent());
    }

    @Test
    public void testForDate_int() throws Exception {
        AgeInfo ageInfo = AgeInfoFactory.forDate(1960, 12, 31);
        verifyDate(ageInfo);
    }
    @Test
    public void testForDate_String() throws Exception {
        AgeInfo ageInfo = AgeInfoFactory.forDate("1960", "12", "31");
        verifyDate(ageInfo);
    }
    @Test
    public void testForDate_javaUtilDate() throws Exception {
        //noinspection deprecation
        AgeInfo ageInfo = AgeInfoFactory.forDate(new Date(60, 11, 31));
        verifyDate(ageInfo);
    }
    private void verifyDate(AgeInfo ageInfo) {
        assertFalse(ageInfo.isEmpty());
        assertEquals((int) ageInfo.getYear().get(), 1960);
        assertEquals((int)ageInfo.getMonth().get(), 12);
        assertEquals((int)ageInfo.getDay().get(), 31);
    }


    @Test
    public void testForYearAndMonth() throws Exception {
        AgeInfo ageInfo = AgeInfoFactory.forYearAndMonth(1960, 12);
        assertFalse(ageInfo.isEmpty());
        assertEquals((int)ageInfo.getYear().get(), 1960);
        assertEquals((int)ageInfo.getMonth().get(), 12);
        assertFalse(ageInfo.getDay().isPresent());
    }

    @Test
    public void testForYear() throws Exception {
        AgeInfo ageInfo = AgeInfoFactory.forYear(1960);
        assertFalse(ageInfo.isEmpty());
        assertEquals((int)ageInfo.getYear().get(), 1960);
        assertFalse(ageInfo.getMonth().isPresent());
        assertFalse(ageInfo.getDay().isPresent());
    }

    @Test
    public void testForYearRange() throws Exception {
        AgeInfo ageInfo = AgeInfoFactory.forYearRange(1960, 1969);
        assertFalse(ageInfo.isEmpty());
        expectNoDate(ageInfo);
        assertEquals((int)ageInfo.getYearRange().getStartIncluding().get(), 1960);
        assertEquals((int)ageInfo.getYearRange().getEndIncluding().get(), 1969);
    }

    @Test
    public void testForYearRangeStart() throws Exception {
        AgeInfo ageInfo = AgeInfoFactory.forYearRangeStart(1960);
        assertFalse(ageInfo.isEmpty());
        expectNoDate(ageInfo);
        assertEquals((int)ageInfo.getYearRange().getStartIncluding().get(), 1960);
        assertFalse(ageInfo.getYearRange().getEndIncluding().isPresent());
    }

    @Test
    public void testForYearRangeEnd() throws Exception {
        AgeInfo ageInfo = AgeInfoFactory.forYearRangeEnd(1969);
        assertFalse(ageInfo.isEmpty());
        expectNoDate(ageInfo);
        assertFalse(ageInfo.getYearRange().getStartIncluding().isPresent());
        assertEquals((int) ageInfo.getYearRange().getEndIncluding().get(), 1969);
    }

    @Test
    public void testForAgeRange() throws Exception {
        int today = getCurrentYear();
        AgeInfo ageInfo = AgeInfoFactory.forAgeRange(20, 65);
        assertFalse(ageInfo.isEmpty());
        expectNoDate(ageInfo);
        assertEquals((int)ageInfo.getYearRange().getStartIncluding().get(), today-65);
        assertEquals((int)ageInfo.getYearRange().getEndIncluding().get(), today-20);
    }

    @Test
    public void testForMinimalAge() throws Exception {
        int today = getCurrentYear();
        AgeInfo ageInfo = AgeInfoFactory.forMinimalAge(20);
        assertFalse(ageInfo.isEmpty());
        expectNoDate(ageInfo);
        assertFalse(ageInfo.getYearRange().getStartIncluding().isPresent());
        assertEquals((int)ageInfo.getYearRange().getEndIncluding().get(), today-20);
    }

    @Test
    public void testForMaximalAge() throws Exception {
        int today = getCurrentYear();
        AgeInfo ageInfo = AgeInfoFactory.forMaximalAge(65);
        assertFalse(ageInfo.isEmpty());
        expectNoDate(ageInfo);
        assertEquals((int)ageInfo.getYearRange().getStartIncluding().get(), today-65);
        assertFalse(ageInfo.getYearRange().getEndIncluding().isPresent());
    }



    private void expectNoDate(AgeInfo ageInfo) {
        assertFalse(ageInfo.getYear().isPresent());
        assertFalse(ageInfo.getMonth().isPresent());
        assertFalse(ageInfo.getDay().isPresent());
    }

    private static int getCurrentYear() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        assertTrue(year>=2013);
        assertTrue(year<=2100);
        return year;
    }
}
