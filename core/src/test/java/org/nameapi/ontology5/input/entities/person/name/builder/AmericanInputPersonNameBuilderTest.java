package org.nameapi.ontology5.input.entities.person.name.builder;

import org.nameapi.ontology5.input.entities.person.name.InputPersonName;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author aa
 */
public class AmericanInputPersonNameBuilderTest {

    @Test
    public void simple() throws Exception {
        InputPersonName inputPersonName = NameBuilders.american()
                .givenName("John")
                .middleName("Fitzgerald")
                .surname("Doe")
                .build();

        assertEquals(inputPersonName.getNameFields().size(), 3);
    }

}
