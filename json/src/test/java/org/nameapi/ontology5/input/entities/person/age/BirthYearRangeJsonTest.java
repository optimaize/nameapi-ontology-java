package org.nameapi.ontology5.input.entities.person.age;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nameapi.ontology5.BaseJsonTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 *
 */
public class BirthYearRangeJsonTest extends BaseJsonTest {

    @Test
    public void test1() throws Exception {
        validate(new BirthYearRange(1960, 1969));
    }

    @Test
    public void test2() throws Exception {
        validate(new BirthYearRange(1960, null));
    }

    @Test
    public void test3() throws Exception {
        validate(new BirthYearRange(null, 1969));
    }

    /**
     * No values is useless, but works.
     */
    @Test
    public void test4() throws Exception {
        validate(new BirthYearRange(null, null));
    }



    private void validate(BirthYearRange original) throws java.io.IOException {
        ObjectMapper jackson = mapper();
        String json = jackson.writeValueAsString(original);
        BirthYearRange recreated = jackson.readValue(json, BirthYearRange.class);
        assertEquals(recreated, original);
    }

}