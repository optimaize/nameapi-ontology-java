package org.nameapi.ontology5.input.entities.person.age;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nameapi.ontology5.BaseJsonTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 *
 */
public class BirthYearJsonTest extends BaseJsonTest {

    @Test
    public void test1() throws Exception {
        BirthYear original = new BirthYear(1960);
        validate(original);
    }

    private void validate(BirthYear original) throws java.io.IOException {
        ObjectMapper jackson = mapper();
        String json = jackson.writeValueAsString(original);
        BirthYear recreated = jackson.readValue(json, BirthYear.class);
        assertEquals(recreated, original);
    }

}