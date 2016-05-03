package org.nameapi.ontology5.input.entities.person.name.types;

import org.nameapi.ontology5.input.entities.person.name.FieldType;

/**
 * Contains the name field types that are often used in America.
 */
public enum AmericanNameFieldType implements FieldType {

    /**
     * American style names have (can have) middle names.
     * These are usually given names, but can also be initials, or surnames, among other things.
     */
    MIDDLENAME,

    /**
     * The name prefix field is used for a titles such as "Dr.".
     */
    NAMEPREFIX,

    /**
     * The name suffix field is used for suffix titles such as "Ph.D." and for qualifiers eg "jr.".
     */
    NAMESUFFIX;



    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int size) {
        assert values().length == size : "Update the code that calls this with outdated size "+size+"!";
    }

    @Override
    public Enum getEnum() {
        return this;
    }

}
