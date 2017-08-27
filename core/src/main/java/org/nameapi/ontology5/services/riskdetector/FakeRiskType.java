package org.nameapi.ontology5.services.riskdetector;

/**
 * Classification of risks.
 *
 * <p>In some situations the exact classification is difficult.
 * For example a person's name may be from fiction, but also be famous at the same time.</p>
 */
public enum FakeRiskType implements RiskType {

    /**
     * Example: "asdf asdf".
     *
     * This kind of input is often used to quickly pass mandatory fields in a form.
     */
    RANDOM_TYPING,

    /**
     * Examples:
     *
     * For person name: "John Doe".
     *
     * For person title: Example: "King Peter"
     *            The given name field doesn't contain a given name, but has at least a title.
     *            It may, in addition, contain a salutation.
     *
     * For salutation: Example: "Mr. Smith" (Mr. in the given name field).
     *                 The given name field doesn't contain a given name, but has a salutation.
     *                 There is no title in it, otherwise PLACEHOLDER_TITLE would be used.
     *
     * For place name: "Anytown"
     */
    PLACEHOLDER,

    /**
     * Examples:
     *
     * For natural person: "James Bond".
     * For legal person: ACME (American Company Making Everything)
     *
     * For place: "Atlantis", "Entenhausen"
     */
    FICTIONAL,

    /**
     * Examples:
     *
     * For natural person: "Barak Obama".
     */
    FAMOUS,

    /**
     * Examples:
     *
     * For natural person: "Sandy Beach".
     * Place example: "Timbuckthree"
     */
    HUMOROUS,

    /**
     * This includes multiple types of invalid form input.
     *
     * Refusing input:
     * Example: "None of your business"
     *
     * Placeholder nouns: "Someone", "Somebody else", "Somewhere", "Nowhere"
     *
     * Repeating the form fields:
     * Example for person name: "firstname lastname"
     * Examples for street: "Street"
     *
     * Vulgar language, swearing
     * Examples: "fuck off"
     */
    INVALID,

    /**
     * The given name and surname field are equal or almost equal, or match a certain pattern.
     * Example: "John" / "John"
     *
     * The risk score is culture adjusted. In some cultures such names do exist, however, a risk is still raised.
     */
    STRING_SIMILARITY,

    /**
     * Everything that does not fit into any of the other categories.
     */
    OTHER,
    ;


    public static void assertSize(int size) {
        assert values().length==size : "Update the code calling FakeRiskType.assertSize() with outdated "+size+" instead of "+values().length+"!";
    }

}
