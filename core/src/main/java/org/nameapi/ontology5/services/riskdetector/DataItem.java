package org.nameapi.ontology5.services.riskdetector;

/**
 * Tells which part of the user's input raised the risk alert.
 */
public enum DataItem {

    /**
     * The person's name (given name, surname, business name, ...).
     */
    NAME,

    /**
     * A person's address (domicile, delivery address, ...) or a part in it (street name, place name, ...).
     */
    ADDRESS,

    /**
     * For natural people it's the birth date
     * For legal people it's the founding time.
     */
    AGE,

    /**
     * An email address.
     */
    EMAIL,

    /**
     * Includes telephone numbers, fax numbers, mobile phone numbers etc.
     */
    TEL,

    /**
     * Any other input item for which there's no dedicated value above.
     */
    OTHER,
    ;

    public static void assertSize(int size) {
        assert values().length==size : "Update the code calling DataItem.assertSize() with outdated "+size+" instead of "+values().length+"!";
    }
}
