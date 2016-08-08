package org.nameapi.ontology5.services.matcher.personmatcher;

/**
 * Tells how two postboxes match.
 *
 */
public enum PostboxMatchType {

    /**
     * The postbox data is the same.
     */
    EQUAL,

    /**
     * One information is more detailed than the other.
     * Example:
     *  - one says "postbox 123" while the other only says "postbox"
     */
    MATCHING,

    /**
     * The information is similar yet different, it could be a data entry mistake.
     * Example:
     *  - one says "postbox 4489" while the other says "postbox 4498"
     */
    SIMILAR,

    /**
     * The data is too different to be considered similar.
     */
    DIFFERENT,
    ;

    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling PostboxMatchType with " + expectedItems + "!";
    }

}
