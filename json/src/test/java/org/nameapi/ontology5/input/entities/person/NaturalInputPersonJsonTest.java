package org.nameapi.ontology5.input.entities.person;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nameapi.ontology5.BaseJsonTest;
import org.nameapi.ontology5.input.entities.address.StructuredPlaceInfoBuilder;
import org.nameapi.ontology5.input.entities.address.StructuredStreetInfoBuilder;
import org.nameapi.ontology5.input.entities.address.StructuredAddressBuilder;
import org.nameapi.ontology5.input.entities.person.age.AgeInfoFactory;
import org.nameapi.ontology5.input.entities.person.gender.StoragePersonGender;
import org.nameapi.ontology5.input.entities.person.name.builder.NameBuilders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 *
 */
public class NaturalInputPersonJsonTest extends BaseJsonTest {

    @Test
    public void test1() throws Exception {
        InputPerson original = new NaturalInputPersonBuilder()
                .name(
                        NameBuilders.western()
                                .givenName("John")
                                .surname("Doe")
                                .build()
                )
                .gender(StoragePersonGender.MALE)
                .age(AgeInfoFactory.forYear(1950))
                .addNationality("US")
                .addNativeLanguage("en")
                .correspondenceLanguage("en")
                .addAddressForAll(new StructuredAddressBuilder()
                                .streetInfo(new StructuredStreetInfoBuilder().streetName("Hill road").houseNumber("512").build())
                                .placeInfo(new StructuredPlaceInfoBuilder()
                                                .locality("Beverly Hills")
                                                .postalCode("90210")
                                                .country("US")
                                                .build()
                                )
                                .build()
                )
                .build();

        validate(original);
    }


    private void validate(InputPerson original) throws java.io.IOException {
        ObjectMapper jackson = mapper();
        String json = jackson.writeValueAsString(original);
        InputPerson recreated = jackson.readValue(json, InputPerson.class);
        assertEquals(recreated, original);
    }
}