package org.nameapi.ontology5.input.entities.address;

/**
 * Lists the possible purposes of an {@link InputAddress}.
 *
 * @author sam
 */
public enum AddressUsage {

    DOMICILE,
    CORRESPONDENCE,
    INVOICE,
    DELIVERY,
    OTHER;

    //TODO
    //PRESENCE current location
    //WORK
    //HOME


    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int size) {
        assert values().length == size : "Update the code that calls this with outdated size "+size+"!";
    }

}
