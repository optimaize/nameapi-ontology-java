package org.nameapi.ontology5.input.entities.address;

import org.nameapi.ontology5.input.entities.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StructuredAddressBuilderTest extends BaseTest {

    @Test
    public void test1() throws Exception {
        StructuredAddress structuredAddress = new StructuredAddressBuilder()
                .streetInfo(new StructuredStreetInfoBuilder()
                        .streetName("Hill road")
                        .houseNumber("512")
                )
                .placeInfo(new StructuredPlaceInfoBuilder()
                        .locality("Beverly Hills")
                        .postalCode("90210")
                        .country("US")
                )
                .build();

        assertTrue(structuredAddress.getStreetInfo().isPresent());
        assertEquals(structuredAddress.getStreetInfo().get().getStreetName().get(), "Hill road");
        assertEquals(structuredAddress.getStreetInfo().get().getHouseNumber().get(), "512");
        assertFalse(structuredAddress.getStreetInfo().get().getBuilding().isPresent());
        assertFalse(structuredAddress.getStreetInfo().get().getStaircase().isPresent());
        assertFalse(structuredAddress.getStreetInfo().get().getFloor().isPresent());
        assertFalse(structuredAddress.getStreetInfo().get().getApartment().isPresent());

        assertTrue(structuredAddress.getPlaceInfo().isPresent());
        assertEquals(structuredAddress.getPlaceInfo().get().getPostalCode().get(), "90210");
        assertEquals(structuredAddress.getPlaceInfo().get().getLocality().get(), "Beverly Hills");
        assertEquals(structuredAddress.getPlaceInfo().get().getCountry().get(), "US");
        assertFalse(structuredAddress.getPlaceInfo().get().getNeighborhood().isPresent());
        assertFalse(structuredAddress.getPlaceInfo().get().getRegion().isPresent());
    }

}
