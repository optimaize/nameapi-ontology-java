package org.nameapi.ontology5.input.entities.person.gender;

import org.nameapi.ontology5.Gender;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * @author sam
 */
public class GenderTest {

    @Test
    public void testToString() {
        Gender gender;

        gender = EffectivePersonGender.MALE;
        assertEquals(gender.toString(), "MALE");

        gender = StoragePersonGender.MALE;
        assertEquals(gender.toString(), "MALE");
    }

}
