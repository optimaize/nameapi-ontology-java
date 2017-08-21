package org.nameapi.ontology5.services.riskdetector;

/**
 */
public enum DisguisedRiskType implements RiskType {
    

    /**
     * Padding example: XXXJohnXXX
     */
    PADDING,

    /**
     * Stutter typing example: Petttttttttterson
     */
    STUTTERTYPING,

    /**
     * Spaced typing example: P e t e r   M i l l e r
     */
    SPACEDTYPING,

    /**
     * Everything not in any of the other categories (enum values).
     */
    OTHER,
    ;


    public static void assertSize(int size) {
        assert values().length==size : "Update the code calling DisguisedRiskType.assertSize() with outdated "+size+" instead of "+values().length+"!";
    }

}
