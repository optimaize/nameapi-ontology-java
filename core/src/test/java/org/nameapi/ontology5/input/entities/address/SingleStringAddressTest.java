package org.nameapi.ontology5.input.entities.address;

import org.nameapi.ontology5.input.entities.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Gabriela Achim
 */
public class SingleStringAddressTest extends BaseTest {
    @Test
    public void testTransform() throws Exception {
        SingleStringAddress singleStringAddress = new SingleStringAddress("Bahnhofstrasse 100");
        SingleStringAddress transformed = singleStringAddress.transform(nullTransformer());
        assertEquals(transformed, null);
    }
}
