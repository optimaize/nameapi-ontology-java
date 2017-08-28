package org.nameapi.ontology5.input.entities.address;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nameapi.ontology5.BaseJsonTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StructuredAddressJsonTest extends BaseJsonTest {

    @Test
    public void test1() throws Exception {
        InputAddress original = new StructuredAddressBuilder()
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

        validate(original);
    }


    private void validate(InputAddress original) throws java.io.IOException {
        ObjectMapper jackson = mapper();
        String json = jackson.writeValueAsString(original);
        InputAddress recreated = jackson.readValue(json, InputAddress.class);
        assertEquals(recreated, original);
    }

}