package org.nameapi.ontology5.input.entities.person.name;

import org.nameapi.ontology5.input.entities.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Gabriela Achim
 */
public class InputPersonNameTest extends BaseTest {
    @Test
    public void testTransform() throws Exception {
        InputPersonName inputPersonName = makeInputPesonName("Foo Bar");
        InputPersonName mod = inputPersonName.transform(nullTransformer());
        assertEquals(mod, null);
    }
}
