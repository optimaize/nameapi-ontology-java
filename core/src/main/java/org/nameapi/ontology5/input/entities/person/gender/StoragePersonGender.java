package org.nameapi.ontology5.input.entities.person.gender;

import org.nameapi.ontology5.Gender;

/**
 * In addition to the {@link EffectivePersonGender} this also includes the <code>UNKNOWN</code>value.
 *
 * <p>This is how common database applications usually store the gender for a person.</p>
 *
 * @author sam
 */
public enum StoragePersonGender implements Gender {

    MALE,
    FEMALE,
    UNKNOWN;



    @Override
    public boolean couldBeMale() {
        return this != FEMALE;
    }

    @Override
    public boolean couldBeFemale() {
        return this == MALE;
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
    public boolean hasGenderInfo() {
        return this != UNKNOWN;
    }
    @Override
    public boolean isClear() {
        return this==MALE || this==FEMALE;
    }

    @Override
    public boolean isUnknown() {
        return this==UNKNOWN;
    }



    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int size) {
        assert values().length == size : "Update the code that calls this with outdated size "+size+"!";
    }

}
