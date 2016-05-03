
package org.nameapi.ontology5.services.matcher.personmatcher;

/**
 * Used in a {@link PersonMatcherResult}.
 *
 * @author Fabian Kessler
 */
public enum PersonMatchType {

    /**
     * Based on the input the people are equal. No difference was found.
     * The names match in full ({@link PersonMatchComposition#FULL}).
     * @see PersonNameMatchType#EQUAL
     */
    EQUAL,

    /**
     * As for EQUAL there was no real difference found, but the names are just matching and not exactly equal.
     * (Or one person matches exactly, but the amounts or types of people differ in some way.)
     * @see PersonNameMatchType#MATCHING
     */
    MATCHING,

    /**
     * The people's information is similar and some difference has been found that speaks against the possibility that
     * they are the same. They may still be the same in case of a data error (mistyping) or when two sets of information
     * are from different points in time (name change, think marriage).
     * @see PersonNameMatchType#SIMILAR
     */
    SIMILAR,

    /**
     * This value is reserved and not in use yet.
     * (example: same family, different person, living at same address in a single family home.)
     */
    RELATION,

    /**
     * Enough differences have been identified that justify to report this.
     * @see PersonNameMatchType#DIFFERENT
     */
    DIFFERENT,
    ;


    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }

}
