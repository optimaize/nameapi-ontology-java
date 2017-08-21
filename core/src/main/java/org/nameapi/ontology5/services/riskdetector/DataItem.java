package org.nameapi.ontology5.services.riskdetector;

/**
 * Tells which part of the user's input raised the risk alert.
 */
public enum DataItem {

    /**
     * The person's name (given name, surname, business name ...).
     */
    NAME,

    /**
     * The person's address (domicile, delivery address, ...).
     */
    ADDRESS,

    /**
     * TODO i think we want to rename this to AGE to be consistent.
     * for natural people it's the birth date
     * for legal people it's the founding time.
     */
    BIRTHDATE,

    /**
     * TODO rename to EMAIL, it's clear what it is.
     */
    EMAIL_ADDRESS,

    /**
     * Includes telephone numbers, fax numbers, mobile phone numbers, and whatever else.
     */
    TEL,
    ;

    public static void assertSize(int size) {
        assert values().length==size : "Update the code calling DataItem.assertSize() with outdated "+size+" instead of "+values().length+"!";
    }
}
