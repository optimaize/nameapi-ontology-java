package org.nameapi.ontology5;

import org.jetbrains.annotations.NotNull;

/**
 * Common interface for gender enums.
 *
 * <p>Fact is that different enums need to be used for different scenarios. Examples:
 * <ul>
 *   <li>A user entering his personal data on a form should only see the options male/female. See {@link org.nameapi.ontology5.input.entities.person.gender.EffectivePersonGender}.</li>
 *   <li>If the field is not mandatory then the storage (db) should also allow null (unknown). See {@link org.nameapi.ontology5.input.entities.person.gender.StoragePersonGender}.</li>
 *   <li>Storing the gender for a dictionary term must also allow the options "neutral" (used for both genders) and
 *       "indeterminable" (does not indicate gender at all).</li>
 *   <li>The gender result of a computation has yet other possible values. See {@link org.nameapi.ontology5.input.entities.person.gender.ComputedPersonGender}.</li>
 * </ul>
 *
 * @author sam
 */
@SuppressWarnings({"JavaDoc"})
public interface Gender {

    /**
     * Something like NEUTRAL is not male.
     * @see #couldBeMale()
     */
    boolean isMale();
    /**
     * Something like NEUTRAL is not female.
     * @see #couldBeFemale()
     */
    boolean isFemale();

    /**
     * Tells if a person with that value assigned could be a male person.
     * Things like UNKNOWN, INDETERMINABLE and NEUTRAL return <code>true</code>.
     */
    boolean couldBeMale();
    /**
     * Tells if a person with that value assigned could be a female person.
     * Things like UNKNOWN, INDETERMINABLE and NEUTRAL return <code>true</code>.
     */
    boolean couldBeFemale();

    /**
     * Tells if the value holds gender information.
     * Things like UNKNOWN and INDETERMINABLE don't, NEUTRAL does.
     */
    boolean hasGenderInfo();

    /**
     * Tells if the gender is clearly on one side, that is either male or female.
     * In cases including unknown, indeterminable and neutral it's not clear.
     */
    boolean isClear();

    /**
     * Tells if the gender is set to UNKNOWN, meaning that we miss information.
     * Indeterminable is not unknown (we *know* that it is unknowable).
     */
    boolean isUnknown();

    /**
     * @return the enum value, eg "MALE".
     */
    @NotNull
    String toString();

}
