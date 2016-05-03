package org.nameapi.ontology5.input.entities.person;

import com.google.common.base.Optional;
import org.nameapi.ontology5.input.entities.BaseTest;
import org.nameapi.ontology5.input.entities.person.age.AgeInfo;
import org.nameapi.ontology5.input.entities.person.age.AgeInfoFactory;
import org.nameapi.ontology5.input.entities.person.gender.StoragePersonGender;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.testng.Assert.assertEquals;

/**
 * @author Gabriela Achim
 */
public class NaturalInputPersonImplTest extends BaseTest {

    @Test
    public void testTransform_1() throws Exception {
        Optional<InputPersonName> inputPersonName = Optional.of(makeInputPesonName("Nadia Smirnoff"));

        NaturalInputPersonImpl naturalInputPerson = new NaturalInputPersonImpl(inputPersonName, StoragePersonGender.UNKNOWN,
                Optional.<AgeInfo>absent(), MaritalStatus.UNKNOWN, Collections.<String>emptyList(), Collections.<String>emptyList(),
                Optional.<String>absent(), Optional.<String>absent(), null, null, null
        );

        NaturalInputPerson mod = naturalInputPerson.transform(nullTransformer());
        assertEquals(mod, null);
    }

    @Test
    public void testTransform_2() throws Exception {
        Optional<InputPersonName> inputPersonName = Optional.of(makeInputPesonName("Nadia Smirnoff"));
        Optional<AgeInfo> age = Optional.of(AgeInfoFactory.forDate(1986, 9, 23));

        NaturalInputPersonImpl naturalInputPerson = new NaturalInputPersonImpl(inputPersonName, StoragePersonGender.FEMALE,
                age, MaritalStatus.SINGLE, Collections.<String>emptyList(), Collections.<String>emptyList(),
                Optional.of("ro"), Optional.of("some-religion"), null, null, null
        );

        NaturalInputPerson mod = naturalInputPerson.transform(nullTransformer());

        NaturalInputPersonImpl expected = new NaturalInputPersonImpl(Optional.<InputPersonName>absent(), StoragePersonGender.FEMALE,
                age, MaritalStatus.SINGLE, Collections.<String>emptyList(), Collections.<String>emptyList(),
                Optional.<String>absent(), Optional.<String>absent(), null, null, null
        );
        assertEquals(mod, expected);
    }

}
