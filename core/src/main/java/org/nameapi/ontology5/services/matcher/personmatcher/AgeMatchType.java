
package org.nameapi.ontology5.services.matcher.personmatcher;

/**
 *
 * @author Fabian Kessler
 */
public enum AgeMatchType {

    /**
     * All data matches, and the completeness is the same.
     * Examples:
     *   "1960-01-31"  vs. "1960-01-31"
     *   "1960"        vs. "1960"
     *   "[1960-1969]" vs. "[1960-1969]"
     *   ""            vs. ""
     */
    EQUAL,

    /**
     * One object is more complete than the other. However, there is no data that mismatches.
     * Examples:
     *   "1960-01-31"  vs. "1960"
     *   "1960-01-31"  vs. ""
     *   "[1960-1969]" vs. "1965"
     */
    PARTIAL,

    NOT_APPLICABLE, //<= here in the middle for sort order

    /**
     * There is conflicting data.
     * Examples:
     *   "1960-01-31"  vs. "1970-02-28"
     *   "1960-01-31"  vs. "1970"
     *   "[1960-1969]" vs. "1985"
     *   "[1960-1969]" vs. "[1970-1979]"
     */
    DIFFERENT,
    ;


    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }

}
