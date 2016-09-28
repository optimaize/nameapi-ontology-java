package org.nameapi.ontology5.services.matcher.personmatcher;

import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.input.entities.address.PlaceInfo;

/**
 * Tells how two place definitions {@link PlaceInfo} match.
 *
 * <p>A place definition may contain a place name, a postal code, and more.</p>
 */
public enum PlaceMatchType {

    /**
     * The place definitions match exactly.
     */
    EQUAL,

    /**
     * One definition is more detailed than the other (and possibly vice versa).
     * The data that is available matches, there is no mismatch.
     * Example:
     *  - one includes the district name within a town, the other does not.
     *  - one specifies postal code and place name, the other only a matching place name.
     */
    MATCHING,

    /**
     * The place definitions have a difference which could come from a data entry mistake.
     * Example:
     *  - same place name, but different postal code.
     */
    SIMILAR,

    /**
     * The place definitions are too different to be considered similar.
     */
    DIFFERENT,
    ;

    public boolean isEqualOrBetterThan(@NotNull PlaceMatchType type) {
        return (this.compareTo(type) <= 0);
    }
    public boolean isEqualOrWorseThan(@NotNull PlaceMatchType type) {
        return (this.compareTo(type) >= 0);
    }
    public boolean isWorseThan(@NotNull PlaceMatchType type) {
        return (this.compareTo(type) > 0);
    }

    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling PlaceMatchType with " + expectedItems + "!";
    }

}
