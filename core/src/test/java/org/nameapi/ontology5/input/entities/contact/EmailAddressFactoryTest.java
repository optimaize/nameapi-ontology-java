package org.nameapi.ontology5.input.entities.contact;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Nicole Torres
 */
public class EmailAddressFactoryTest {

    @Test
    public void testForAddress() throws Exception {
        String s = "info@example.org";
        EmailAddress emailAddress = EmailAddressFactory.forAddress(s);
        assertEquals(emailAddress.getEmailAddress(), s);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void test_empty() throws Exception {
        EmailAddressFactory.forAddress("");
    }
}
