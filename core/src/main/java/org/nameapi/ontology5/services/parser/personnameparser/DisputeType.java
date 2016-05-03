package org.nameapi.ontology5.services.parser.personnameparser;

/**
 * Lists the possible parser dispute types.
 *
 * @author Nicole Torres
 */
public enum DisputeType {

    /**
     * The detected person gender mismatches the one passed in by the API user, or the parsed person
     * uses terms of opposing gender.
     */
    GENDER,

    /**
     * The spelling of a word (name) looks wrong. It may have been corrected in the parsed name output.
     */
    SPELLING;

    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }

}
