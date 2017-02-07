package org.nameapi.ontology5.services.matcher.personmatcher;

/**
 * Tells how two phone numbers match.
 *
 * <p>The term "tel" includes fixed and mobile phones, as well as other technologies including Fax, VoIP, etc.
 * The name "Tel" was chosen because VCard http://en.wikipedia.org/wiki/VCard uses it too.</p>
 *
 */
public enum TelNumberMatchType {

    /**
     * The two numbers matched exactly, ignoring formatting.
     * This usually means that all digits were equal.
     * Different syntax for country codes like "+44" vs "0044" are considered equal.
     * Having an internationally formatted number with and without a bracket for a number to be dialed only
     * locally, eg "+44 (0) 999" vs "+44 999", is considered equal.
     * 
     * <p>As of now this value is also used for a number vs the equivalent phoneword.
     * Example: "0800 AGSMUEHLHEIM" vs "0800247683454346"
     * A new value "MATCHING" or "EQUIVALENT" could be introduced for such kinds.</p>
     */
    EQUAL,

    /**
     * One number is in international format, the other in national (without country prefix).
     * Other than that they are equal.
     * Such numbers usually mean the same destination, but can be different when used in different contexts.
     */
    NATIONAL,

    /**
     * One of the two numbers is in national or international format, the other in local only.
     * Other than that they are equal.
     * Such numbers usually mean the same destination, but can be different when used in different contexts.
     */
    LOCAL,

    /**
     * The numbers are close in the end digits. Companies have whole blocks aka ranges of numbers assigned.
     * Therefore a number ending in 01 and in 02 are possibly going to the same office.
     */
    CLOSE,

    /**
     * The stem of the two numbers is equal, but not so the prefix or country code.
     * Usually that's a different target, but it could be a mistake in the prefix or a number that has been
     * moved to another area or provider.
     */
    STEM,

    /**
     * The numbers are different, but show some similarity in the digits. It is possible that the difference
     * comes from a [typing] mistake.
     */
    SIMILAR,

    /**
     * Same as {@link #SIMILAR}, but at least one of the numbers is considered invalid.
     */
    SIMILAR_INVALID,

    /**
     * The numbers are too different to be considered similar.
     */
    DIFFERENT,
    ;



    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling PhoneNumberMatchType with " + expectedItems + "!";
    }

}
