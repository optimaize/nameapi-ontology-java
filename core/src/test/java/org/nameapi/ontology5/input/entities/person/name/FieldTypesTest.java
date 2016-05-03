package org.nameapi.ontology5.input.entities.person.name;

import org.nameapi.ontology5.input.entities.person.name.types.CommonNameFieldType;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * @author aa
 */
public class FieldTypesTest {

    @Test
    public void testValueOf() throws Exception {
        assertTrue(FieldTypes.valueOf("FULLNAME") == CommonNameFieldType.FULLNAME);
        assertTrue(FieldTypes.valueOf("GIVENNAME") == CommonNameFieldType.GIVENNAME);
    }

}
