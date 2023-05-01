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

    /**
     * When a term is interpreted as something, but it would be much more likely to have another meaning.
     * Example: "Theodor" interpreted as surname.
     */
    TERM_INTERPRETATION,

    /**
     * When the string is syntactically broken and needs a fix, eg comma or dot in the wrong place, spacing errors.
     */
    SYNTAX,

    /**
     * A term that is used for multiple things.
     * <p>
     * Example: gn="Francois Martin", sn="Martin"
     * The word "Martin" appears twice in the input. If it is used in the interpretation as both the
     * 2nd given name, and the surname, then we have a DUPLICATE_USE. If instead one on the occurrences is
     * ignored then there will be a {@link #DUPLICATE_CONTENT} dispute.
     * <p>
     * The use is per person. That is: "Peter and Maria Meyer" are 2 people, both are called Meyer, and
     * we do not have a duplicate term here.
     * <p>
     * Note: this javadoc was copied from {@code NameParserDispute#DisputeType} of 'onoserver' software.
     */
    DUPLICATE_USE,

    ;

    @SuppressWarnings("squid:S4274") // assert keyword
    public static void assertSize(int size) {
        int valuesCount = values().length;
        assert valuesCount == size :
                "Update the code calling DisputeType.assertSize() with outdated " + size +
                        " instead of " + valuesCount + "!";
    }

}
