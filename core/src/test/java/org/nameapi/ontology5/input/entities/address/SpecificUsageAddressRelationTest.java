package org.nameapi.ontology5.input.entities.address;

import org.nameapi.ontology5.input.entities.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Gabriela Achim
 */
public class SpecificUsageAddressRelationTest extends BaseTest {
    @Test
    public void testTransform() throws Exception {
        SpecificUsageAddressRelation addressRelation = new SpecificUsageAddressRelation(
                new SingleStringAddress("bahnhofstrasse"), AddressUsage.DOMICILE
        );
        AddressRelation transformed = addressRelation.transform(nullTransformer());
        assertEquals(transformed, null);
    }
}
