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
    SPELLING,

    /**
     * Field inputs are swapped, for example the given name appears in the surname field and vice versa.
     * The fields were interpreted differently than they were passed in.
     */
    TRANSPOSITION,

    /**
     * For example a title appears in the title and in the given name field, one was ignored.
     * Another example is: full name in given name and in surname field.
     * The duplicate values were ignored.
     */
    DUPLICATE_CONTENT,
    ;

    public static void assertSize(int size) {
        assert values().length==size : "Update the code calling DisputeType.assertSize() with outdated "+size+" instead of "+values().length+"!";
    }

}
