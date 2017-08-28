package org.nameapi.ontology5.input.entities.contact;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nameapi.ontology5.BaseJsonTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EmailAddressJsonTest extends BaseJsonTest {

    @Test
    public void test1() throws Exception {
        EmailAddress original = EmailAddressFactory.forAddress("info@example.org");
        validate(original);
    }


    private void validate(EmailAddress original) throws java.io.IOException {
        ObjectMapper jackson = mapper();
        String json = jackson.writeValueAsString(original);
        EmailAddress recreated = jackson.readValue(json, EmailAddress.class);
        assertEquals(recreated, original);
    }

}