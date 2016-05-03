package org.nameapi.ontology5.input.entities.person.age;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nameapi.ontology5.BaseJsonTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 *
 */
public class AgeInfoJsonTest extends BaseJsonTest {

    @Test
    public void testBirthDate() throws Exception {
        AgeInfo original = new BirthDate(1960, 2, 15);
        validate(original);
    }

    @Test
    public void testBirthYearMonth() throws Exception {
        AgeInfo original = new BirthYearMonth(1960, 2);
        validate(original);
    }

    @Test
    public void testBirthYear() throws Exception {
        AgeInfo original = new BirthYear(1960);
        validate(original);
    }

    @Test
    public void testBirthYearRange() throws Exception {
        AgeInfo original = new BirthYearRange(1960, 1969);
        validate(original);
    }


    private void validate(AgeInfo original) throws java.io.IOException {
        ObjectMapper jackson = mapper();
        String json = jackson.writeValueAsString(original);
        AgeInfo recreated = jackson.readValue(json, AgeInfo.class);
        assertEquals(recreated, original);
    }

}