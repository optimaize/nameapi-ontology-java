package org.nameapi.ontology5.input.entities.person.name.types;

import org.nameapi.ontology5.input.entities.person.name.FieldType;

/**
 * A place for "other" types that don't fit into Common and are not too culture specific.
 *
 */
public enum OtherNameFieldType implements FieldType {

    ADDITIONAL_NAME,

    /**
     * A field where the surname at birth of the person can be entered. Also known as "maiden name".
     */
    MAIDEN_SURNAME,

    /**
     * vCard introduced this in version 3 and still has it in 4.
     * Previously it used the title attribute for it.
     */
    NICKNAME,

    /**
     * An input field that is used for the address.
     *
     * <p>Examples:
     * <pre>
     * "Ms."
     * "Mister"
     * "Dr."
     * "Prof. Dr."
     * </pre></p>
     */
    SALUTATION,

    /**
     * An input field that is used for titles, eg "Dr." or "Prof. Dr.".
     * This is similar to the {@link AmericanNameFieldType#NAMEPREFIX}.
     */
    TITLE,

    QUALIFIER,

    ;

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
