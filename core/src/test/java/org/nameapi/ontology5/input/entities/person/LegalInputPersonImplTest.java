package org.nameapi.ontology5.input.entities.person;

import com.google.common.base.Optional;
import org.nameapi.ontology5.input.entities.BaseTest;
import org.nameapi.ontology5.input.entities.person.age.AgeInfo;
import org.nameapi.ontology5.input.entities.person.age.AgeInfoFactory;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Gabriela Achim
 */
public class LegalInputPersonImplTest extends BaseTest {

    @Test
    public void testTransform() throws Exception {
        Optional<InputPersonName> personName = Optional.of(makeInputPesonName("Some Company Inc."));
        Optional<AgeInfo> age = Optional.of(AgeInfoFactory.forYear(1996));

        InputPerson legalInputPerson = new LegalInputPersonImpl(
                personName,
                age,
                Optional.of("de"),
                null, null, null
        );

        InputPerson mod = legalInputPerson.transform(nullTransformer());
        InputPerson expected = new LegalInputPersonImpl(
                Optional.<InputPersonName>absent(),
                age,
                Optional.<String>absent(),
                null, null, null
        );
        assertEquals(mod, expected);
    }

}
