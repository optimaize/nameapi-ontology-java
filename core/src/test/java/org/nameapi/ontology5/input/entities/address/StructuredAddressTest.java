package org.nameapi.ontology5.input.entities.address;

import com.google.common.base.Optional;
import org.nameapi.ontology5.input.entities.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Gabriela Achim
 */
public class StructuredAddressTest extends BaseTest {

    @Test
    public void testTransform() throws Exception {
        StreetInfo streetInfo = new SingleStringStreetInfo("Bahnhofstrasse 100");
        StructuredAddress structuredPlaceInfo = new StructuredAddress(
                Optional.of(streetInfo),
                Optional.of("400620"),
                Optional.<PlaceInfo>absent());

        InputAddress transformed = structuredPlaceInfo.transform(nullTransformer());
        assertEquals(transformed, null);
    }
}
