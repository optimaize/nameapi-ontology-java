package org.nameapi.ontology5.input.entities.person.age;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nameapi.ontology5.BaseJsonTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 *
 */
public class BirthYearMonthJsonTest extends BaseJsonTest {

    @Test
    public void test1() throws Exception {
        BirthYearMonth original = new BirthYearMonth(1960, 2);
        validate(original);
    }

    private void validate(BirthYearMonth original) throws java.io.IOException {
        ObjectMapper jackson = mapper();
        String json = jackson.writeValueAsString(original);
        BirthYearMonth recreated = jackson.readValue(json, BirthYearMonth.class);
        assertEquals(recreated, original);
    }

}