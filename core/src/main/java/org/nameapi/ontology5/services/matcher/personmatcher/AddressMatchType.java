package org.nameapi.ontology5.services.matcher.personmatcher;

/**
 * Tells how two physical addresses match.
 *
 */
public enum AddressMatchType {

    /**
     * The addresses match exactly.
     */
    EQUAL,

    /**
     * There is a neglectable difference, both addresses point to the same place or building.
     *
     * Examples:
     *  - a mismatching postal code
     *  - an alternative or translated place name
     *  - a former street name
     *  - a former postal code
     */
    SAME,

    /**
     * One address is more detailed than the other (and possibly vice versa).
     * The data that is available matches, there is no mismatch.
     * Examples:
     *  - one address only names the street name, the other also the street number.
     *  - one address only names the street number, the other also a variant, or floor, or apartment number.
     */
    MATCHING,

    /**
     * The addresses match in location, but one goes to a house address while the other goes to the post office.
     * Either to a postbox, or to "Postlagernd".
     */
    POST,

    /**
     * The addresses are different, but physically very close to each other.
     */
    NEARBY,

    /**
     * The addresses have a difference which could come from a data entry mistake.
     */
    SIMILAR,

    /**
     * The addresses are too different to be considered similar.
     */
    DIFFERENT,
    ;

    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling AddressMatchType with " + expectedItems + "!";
    }

}
