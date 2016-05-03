
package org.nameapi.ontology5.services.matcher.personmatcher;

/**
 * @author Fabian Kessler
 */
public enum PersonNameMatchType {

    /**
     * The names match in full. Difference can only be in case and spacing, and some punctuation.
     *
     * <p>Examples:
     * <ul>
     * <li>"Andre Müller" vs. "Andre Müller"</li>
     * <li>"andre müller" vs. "Andre Müller"</li>
     * </ul></p>
     */
    EQUAL,

    /**
     * Not exactly equal, but no mismatch.
     * <p>Examples:
     * <ul>
     * <li>"André Muller" vs. "Andre Müller"</li>
     * <li>"Andre Müller" vs. "A. Müller"</li>
     * <li>"Andre Müller" vs. "Andre Müller-Meyer"</li>
     * <li>"Andre Müller" vs. "Andy Müller"</li>
     * </ul></p>
     */
    MATCHING,

    /**
     * The names are similar, however, it's probably another person.
     * <p>Examples:
     * <ul>
     * <li>"Karin Müller" vs. "Karim Müller"</li>
     * </ul></p>
     *
     * <p>How similar is told in getPoints().</p>
     */
    SIMILAR,

    /**
     * A neutral "nothing found".
     * <p>Unlikely the same person.</p>
     */
    NO_SIMILARITY_FOUND,

    /**
     * The names are different and so are the people.
     * <p>Unless the two names are snapshots of the same person take at different times (think marriage).</p>
     */
    DIFFERENT,
    ;


    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }

}
