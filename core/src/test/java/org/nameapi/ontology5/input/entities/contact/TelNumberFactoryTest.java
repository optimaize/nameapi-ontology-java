package org.nameapi.ontology5.input.entities.contact;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Nicole Torres
 */
public class TelNumberFactoryTest {

    @Test
    public void testForNumber() throws Exception {
        String s = "+33 3 86 30 77 88";
        TelNumber telNumber = TelNumberFactory.forNumber(s);
        assertEquals(telNumber.getFullNumber(), s);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void test_empty() throws Exception {
        TelNumberFactory.forNumber("");
    }
}
