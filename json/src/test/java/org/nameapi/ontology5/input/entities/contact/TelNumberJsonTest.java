package org.nameapi.ontology5.input.entities.contact;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nameapi.ontology5.BaseJsonTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TelNumberJsonTest extends BaseJsonTest {

    @Test
    public void test1() throws Exception {
        TelNumber original = TelNumberFactory.forNumber("+33 3 86 30 77 88");
        validate(original);
    }


    private void validate(TelNumber original) throws java.io.IOException {
        ObjectMapper jackson = mapper();
        String json = jackson.writeValueAsString(original);
        TelNumber recreated = jackson.readValue(json, TelNumber.class);
        assertEquals(recreated, original);
    }

}