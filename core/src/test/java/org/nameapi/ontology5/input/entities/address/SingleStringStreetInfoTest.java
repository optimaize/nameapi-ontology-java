package org.nameapi.ontology5.input.entities.address;

import org.nameapi.ontology5.input.entities.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Gabriela Achim
 */
public class SingleStringStreetInfoTest extends BaseTest {

    @Test
    public void testTransform() throws Exception {
        SingleStringStreetInfo stringStreetInfo = new SingleStringStreetInfo("Bahnhofstrasse 100");
        StreetInfo transformed = stringStreetInfo.transform(nullTransformer());
        assertEquals(transformed, null);
    }
}
