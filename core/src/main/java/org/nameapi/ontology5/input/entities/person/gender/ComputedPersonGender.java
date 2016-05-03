package org.nameapi.ontology5.input.entities.person.gender;

import org.nameapi.ontology5.Gender;

/**
 * A gender as a result of a computation for a person.
 *
 * TODO is this the right place? it's not input... should be in output.
 * TODO Maybe some of these should be in a 'common' place (StoragePersonGender, EffectivePersonGender).
 *
 * @author sam
 */
public enum ComputedPersonGender implements Gender {

    /**
     * The result is clearly 'male'.
     */
    MALE,

    /**
     * The result is clearly 'female'.
     */
    FEMALE,

    /**
     * Can be either male or female. The chance should be reported in another field.
     */
    NEUTRAL,

    /**
     * No gender could be computed, but better intelligence should be able to tell the gender.
     * An example is a name input of which we have never heard before.
     */
    UNKNOWN,

    /**
     * From the given data it is or seems impossible to tell the gender.
     * For example all terms are gender-inapplicable, or there are no names at all.
     * Thus this differs from NEUTRAL where something is clearly known to be neutral.
     * <p>Name: we have decided that INDETERMINABLE is the correct word here, not INAPPLICCABLE.</p>
     */
    INDETERMINABLE,

    /**
     * There are conflicting genders in the given data.
     *
     * <p>Example: "Mr Daniela Miller" (salutation vs. given name)</p>
     *
     * <p>The input data must be manually reviewed. It is impossible and useless to make a guess
     * (garbage in would only cause garbage out).</p>
     */
    CONFLICT;

    @Override
    public boolean couldBeMale() {
        return this != FEMALE;
    }

    @Override
    public boolean couldBeFemale() {
        return this != MALE;
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
        return this==MALE || this==FEMALE || this==NEUTRAL;
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
