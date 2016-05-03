package org.nameapi.ontology5.input.entities.person.name.types;

import org.nameapi.ontology5.input.entities.person.name.FieldType;

/**
 * ...
 *
 */
public enum LegalNameFieldType implements FieldType {

    /**
     * The whole business name as one field, possibly including the legal form.
     * <p>Also known as "formatted name", for example by vCard.</p>
     * <p>Also known as "raw name".</p>
     * <p>Examples:
     * <pre>
     *   "Google"
     *   "Google Inc."
     *   "Google Incorporated"
     * </pre></p>
     */
    LEGAL_NAME,

    /**
     * Only the legal form, in full or abbreviated, eg "Ltd." or "Limited".
     */
    LEGAL_FORM,

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
