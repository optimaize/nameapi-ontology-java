package org.nameapi.ontology5.services.matcher.personmatcher;

import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.input.entities.address.StreetInfo;

/**
 * Tells how two street definitions {@link StreetInfo} match.
 *
 * <p>A street definition may contain the street name, number, block, entrance, floor, apartment etc.</p>
 *
 */
public enum StreetMatchType {

    /**
     * The street definitions match exactly.
     */
    EQUAL,

    /**
     * One definition is more detailed than the other (and possibly vice versa).
     * The data that is available matches, there is no mismatch.
     * Examples:
     *  - one address only names the street name, the other also the street number.
     *  - one address only names the street number, the other also a variant, or floor, or apartment number.
     */
    MATCHING,

    /**
     * The street definitions have a difference which could come from a data entry mistake.
     */
    SIMILAR,

    /**
     * The street definitions are too different to be considered similar.
     */
    DIFFERENT,
    ;

    public boolean isEqualOrBetterThan(@NotNull StreetMatchType type) {
        return (this.compareTo(type) <= 0);
    }
    public boolean isEqualOrWorseThan(@NotNull StreetMatchType type) {
        return (this.compareTo(type) >= 0);
    }
    public boolean isWorseThan(@NotNull StreetMatchType type) {
        return (this.compareTo(type) > 0);
    }

    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling StreetMatchType with " + expectedItems + "!";
    }

}
