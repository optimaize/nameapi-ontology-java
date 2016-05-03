package org.nameapi.ontology5.input.entities.person.age;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nameapi.ontology5.BaseJsonTest;
import org.nameapi.ontology5.input.context.Context;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 *
 */
public class BirthDateJsonTest extends BaseJsonTest {

    @Test
    public void test1() throws Exception {
        BirthDate original = new BirthDate(1960, 2, 15);
        validate(original);
    }

    private void validate(BirthDate original) throws java.io.IOException {
        ObjectMapper jackson = mapper();
        String json = jackson.writeValueAsString(original);
        BirthDate recreated = jackson.readValue(json, BirthDate.class);
        assertEquals(recreated, original);
    }
}