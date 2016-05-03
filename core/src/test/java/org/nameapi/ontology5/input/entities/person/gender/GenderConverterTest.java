package org.nameapi.ontology5.input.entities.person.gender;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author sam
 */
public class GenderConverterTest {

    @Test
    public void testEffectiveGender() {
        assertEquals(GenderConverter.toStorageGender(EffectivePersonGender.MALE), StoragePersonGender.MALE);
        assertEquals(GenderConverter.toStorageGender(EffectivePersonGender.FEMALE), StoragePersonGender.FEMALE);
        for (EffectivePersonGender g : EffectivePersonGender.values()) {
            GenderConverter.toStorageGender(g);
        }
    }

}
