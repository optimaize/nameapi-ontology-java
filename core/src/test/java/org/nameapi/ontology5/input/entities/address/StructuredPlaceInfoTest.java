package org.nameapi.ontology5.input.entities.address;

import com.google.common.base.Optional;
import org.nameapi.ontology5.input.entities.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Gabriela Achim
 */
public class StructuredPlaceInfoTest extends BaseTest {

    @Test
    public void testTransform() throws Exception {
        StructuredPlaceInfo structuredPlaceInfo = new StructuredPlaceInfo(
                Optional.of("Cluj"), Optional.of("400620"), Optional.<String>absent(), Optional.<String>absent(), Optional.<String>absent());

        PlaceInfo placeInfo = structuredPlaceInfo.transform(nullTransformer());
        assertEquals(placeInfo, null);
    }


}
