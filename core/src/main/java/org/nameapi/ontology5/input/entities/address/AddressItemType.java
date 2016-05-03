package org.nameapi.ontology5.input.entities.address;

/**
 * All chunks of information that may be present in an {@link InputAddress}.
 *
 * @author Fabian Kessler
 */
public enum AddressItemType {

    /**
     * The street name.
     * Without other information such as street number.
     * It may include the type of street, such as "street" or "alley" or "road" etc.
     */
    STREETNAME,

    /**
     * The street "number" or identifier, doesn't have to be numeric.
     * Without other information such as building identifier, stairway, floor or apartment.
     */
    STREETNUMBER,

    /**
     * The building/block identifier (not to confuse with street number).
     * Without other information such as stairway, floor or apartment.
     * It may include the block prefix such as "block" or "bl." or so.
     * For example Romania uses this information in cities.
     * Examples: "Bl. I19", "I19".
     */
    BUILDING,

    /**
     * The entrance/staircase identifier.
     * Without other information such as floor or apartment.
     * Finland and Romania use this information.
     * Examples: "Sc. 2", "2", "C"
     */
    STAIRCASE,

    /**
     * The building's floor number.
     * Without other information such as the apartment/suite number.
     * Denmark, Romania and other countries use this information.
     * Examples: "Et. 2", "2"
     */
    FLOOR,

    /**
     * Apartment aka Suite identifier.
     * Examples:
     *   "Ap. 25", "Suite 207", "25"
     *   "t.h." or "t.v." in Denmark
     */
    APARTMENT,


    /**
     * The postal code aka post code or zipcode.
     *
     * <p>Not all countries use a postal code.</p>
     *
     * <p>See http://en.wikipedia.org/wiki/Postal_code</p>
     *
     * Examples:
     *   "94107" USA
     *   "H3Z 2Y7" Canada
     *   "8022" Switzerland
     *   "CH-8022" Switzerland, european style of adding country code as prefix
     */
    POSTALCODE,

    /**
     * The city/town/village/municipality/place name.
     */
    LOCALITY,

    /**
     * The city area/neighborhood/district/sector information.
     * Examples:
     *   "Vila Industrial" in Brazil
     *   "Sector 6" in Romania, only used in the capital Bucharest
     */
    NEIGHBORHOOD,

    /**
     * The region or region code (state, county, province), such as "CA" in the USA for California.
     * Examples:
     *   "CA" for California USA
     *   "Jud. Brasov" in Romania
     */
    REGION,

    /**
     * The country code or name in any language.
     * Examples:
     *   "DE" Germany (ISO 3166-alpha2 code)
     *   "Germany"
     *   "U.S.A."
     */
    COUNTRY;


    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int size) {
        assert values().length == size : "Update the code that calls this with outdated size "+size+"!";
    }

}
