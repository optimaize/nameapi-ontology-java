package org.nameapi.ontology5.input.entities.person.name;

import org.nameapi.ontology5.input.entities.BaseTest;
import org.nameapi.ontology5.input.entities.person.name.types.CommonNameFieldType;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Gabriela Achim
 */
public class NameFieldTest extends BaseTest {

    @Test
    public void testTransform() throws Exception {
        NameField fullName = new NameField("GivenName FamilyName", CommonNameFieldType.FULLNAME);
        NameField mod = fullName.transform(nullTransformer());
        assertEquals(mod, null);
    }
}
