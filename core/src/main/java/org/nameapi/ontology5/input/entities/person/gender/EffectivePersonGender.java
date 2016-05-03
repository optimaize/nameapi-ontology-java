package org.nameapi.ontology5.input.entities.person.gender;

import org.nameapi.ontology5.Gender;

/**
 * The genders that exist for a person by common law.
 *
 * <p>This enum is used in contexts where the gender is always known.</p>
 *
 * <p>Do not use this class with <code>null</code> values. If you need the "unknown" value then use
 * {@link StoragePersonGender}.</p>
 *
 * @author sam
 */
public enum EffectivePersonGender implements Gender {

    MALE,
    FEMALE;


    @Override
    public boolean couldBeMale() {
        return this == MALE;
    }

    @Override
    public boolean couldBeFemale() {
        return this == FEMALE;
    }

    @Override
    public boolean isMale() {
        return this == MALE;
    }
    @Override
    public boolean isFemale() {
        return this == FEMALE;
    }

    @Override
    public boolean isClear() {
        return true;
    }


    @Override
    public boolean hasGenderInfo() {
        return true;
    }

    @Override
    public boolean isUnknown() {
        return false;
    }


    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int size) {
        assert values().length == size : "Update the code that calls this with outdated size "+size+"!";
    }

}
