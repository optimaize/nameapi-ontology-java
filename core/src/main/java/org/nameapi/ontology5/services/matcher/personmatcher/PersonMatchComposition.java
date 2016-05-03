
package org.nameapi.ontology5.services.matcher.personmatcher;

/**
 * Tells how much the two people have in common.
 *
 * @author Fabian Kessler
 * @author Nicole Torres
 */
public enum PersonMatchComposition {

    /**
     * The two completely overlap.
     * It can be for example 1 vs 1 person, or 2 vs the same other 2 people.
     *
     * <pre>
     *    +-----A-----+
     *    |           |
     *    |           B
     *    |           |
     *    +-----------+
     * </pre>
     */
    FULL,

    /**
     * One is part of the other.
     * Example: "Peter Smith" vs. "Peter and Mary Smith".
     * It can be for example 1 vs 2 people, or 2 vs 3, or a business vs an natural person.
     *
     * <pre>
     *    +-----A-----+
     *    |           |
     *    |  +----B---+
     *    |  |        |
     *    |  |        |
     *    +--+--------+
     * </pre>
     */
    PARTIAL,

    /**
     * Both have something in common and something extra.
     * It can be for example 2 vs 2 people where one on both side matches.
     *
     * <pre>
     *          +-------B----+
     *          |            |
     *    +--A--------+      |
     *    |     |     |      |
     *    |     +------------+
     *    |           |
     *    +-----------+
     * </pre>
     */
    INTERSECTION,

    /**
     * When there is no match.
     */
    NOT_APPLICABLE,
    ;


    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }

}
