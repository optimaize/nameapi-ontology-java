package org.nameapi.ontology5.input.entities.address;

import com.google.common.base.Optional;
import org.nameapi.ontology5.input.entities.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Gabriela Achim
 */
public class StructuredStreetInfoTest extends BaseTest {

    @Test
    public void testTransform() throws Exception {
        StructuredStreetInfo structuredStreetInfo = new StructuredStreetInfo(
                Optional.of("Banhofstrasse"), Optional.of("100"), Optional.<String>absent(), Optional.<String>absent(), Optional.<String>absent(), Optional.<String>absent()
        );

        StreetInfo streetInfo = structuredStreetInfo.transform(nullTransformer());
        assertEquals(streetInfo, null);
    }

}
