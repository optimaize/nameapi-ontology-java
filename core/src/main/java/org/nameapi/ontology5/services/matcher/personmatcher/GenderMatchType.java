
package org.nameapi.ontology5.services.matcher.personmatcher;

/**
 * @author Fabian Kessler
 */
public enum GenderMatchType {

    /**
     * Both have the same gender with a high confidence; either both are MALE or both are FEMALE.
     */
    EQUAL,

    /**
     * It looks like both have the same gender. For at least one of the people the gender is not absolutely clear,
     * but it looks good.
     * Example use case: one person has a MALE name, the other has a neutral name that is more likely MALE.
     */
    POSSIBLY_EQUAL,

    /**
     * It looks like they have opposite gender. For at least one of the people the gender is not absolutely clear,
     * but it looks like it's mismatching.
     * Example use case: one person has a MALE name, the other has a neutral name that is more likely FEMALE.
     */
    POSSIBLY_DIFFERENT,

    /**
     * At least for one no gender information is available/determined, therefore comparision is not possible.
     */
    NOT_APPLICABLE, //<= here in the middle for sort order

    /**
     * One is MALE while the other is FEMALE.
     */
    DIFFERENT,
    ;

    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }

}
