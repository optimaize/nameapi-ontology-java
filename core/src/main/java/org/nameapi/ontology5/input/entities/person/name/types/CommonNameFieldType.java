package org.nameapi.ontology5.input.entities.person.name.types;

import org.nameapi.ontology5.input.entities.person.name.FieldType;

/**
 * Contains the name field types that are commonly shared by many cultures.
 *
 */
public enum CommonNameFieldType implements FieldType {

    /**
     * The whole name as one field.
     * <p>Also known as "formatted name", for example by vCard.</p>
     * <p>Also known as "raw name".</p>
     */
    FULLNAME,

    /**
     * An input field to enter one or multiple given names (first names), possibly abbreviated.
     */
    GIVENNAME,

    /**
     * An input field to enter one or multiple surnames (last names).
     */
    SURNAME,

    ;


    public boolean isGivenName() {
        return this==GIVENNAME;
    }

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
