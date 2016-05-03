package org.nameapi.ontology5.input.entities.person.name.builder;

import org.nameapi.ontology5.input.entities.person.name.InputPersonName;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author aa
 */
public class WesternInputPersonNameBuilderTest {

    @Test
    public void simple() throws Exception {
        InputPersonName inputPersonName = NameBuilders.western()
                .givenName("John")
                .surname("Doe")
                .build();

        assertEquals(inputPersonName.getNameFields().size(), 2);
    }

    @Test
    public void twoSurnames() throws Exception {
        InputPersonName inputPersonName = NameBuilders.western()
                .givenName("Anna-Lena")
                .surname("Huber")
                .surname("Oberholzer")
                .build();

        assertEquals(inputPersonName.getNameFields().size(), 3);
    }

}
