package org.nameapi.ontology5.services.riskdetector;

/**
 * Lists all the possible types of risks.
 */
public enum FakeRiskType implements RiskType {
    
    /**
     * Such as "asdf asdf".
     */
    RANDOM_TYPING,

    /**
     * Examples:
     * 
     * For name: "John Doe".
     * 
     * For title: The given name field doesn't contain a given name, but has at least a title.
     *            It may, in addition, contain a salutation.
     *            Example: "King Peter"
     * 
     * For salutation: The given name field doesn't contain a given name, but has a salutation.
     * There is no title in it, otherwise PLACEHOLDER_TITLE would be used.
     * Example: "Mr. Smith" (Mr. in the given name field).
     */
    PLACEHOLDER,
    
    /**
     * Examples:
     * 
     * For name: "James Bond".
     * For Organization: ACME (American Company Making Everything)
     * 
     * For place: Atlantis, Entenhausen
     */
    FICTIONAL,

    /**
     * Name example: "Barak Obama".
     * 
     * Address example: the address of the white house.
     */
    FAMOUS,

    /**
     * Name example: "Sandy Beach".
     * Place example: Fucking (in Austria)
     */
    HUMEROUS,

    /**
     * Examples for name: 
     * "firstname lastname"
     * 
     * Examples for street: "Street"
     * 
     * Examples in general: such as vulgar language "fuck off", etc.
     */
    INVALID,

    /**
     * The gn and sn field are similar: equal, levenshtein-similar, starts-with, ends-with.
     */
    STRING_SIMILARITY,

    /**
     * Everything not in any of the other categories (enum values).
     */
    OTHER,
    ;


    public static void assertSize(int size) {
        assert values().length==size : "Update the code calling FakeRiskType.assertSize() with outdated "+size+" instead of "+values().length+"!";
    }

}
