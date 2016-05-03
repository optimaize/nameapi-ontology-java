package org.nameapi.ontology5.input.entities.person.name.types;

import org.nameapi.ontology5.input.entities.person.name.FieldType;

/**
 * The *traditional* name fields of the Arabic culture.
 *
 * <p>For Arabic scenarios that use a western naming system, the Western or American types are the ones to use instead.</p>
 */
public enum ArabicNameFieldType implements FieldType {

    ISM,
    KUNYA,

    NASAB,
    LAQAB,
    NISBAH;


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
