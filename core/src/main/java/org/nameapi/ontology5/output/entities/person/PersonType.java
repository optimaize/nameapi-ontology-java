package org.nameapi.ontology5.output.entities.person;

/**
 * Types of natural and legal people, and groups of them.
 *
 * @author Nicole Torres
 * @author Fabian Kessler
 */
public enum PersonType {

    /**
     * A sole individual.
     * <p>The term 'single' has nothing to do with the marital status.</p>
     * <p>Example: "Peter Smith".</p>
     */
    NATURAL,

    /**
     * When it's certainly a family. The number of people is unspecified.
     * <p>Example: "Familie Meyer".</p>
     */
    FAMILY,

    /**
     * A non-natural, legal person such as a single business or single company or NGO or whatever is a legal
     * person by law.
     * <p>Example: "ACME Inc."</p>
     */
    LEGAL,

    /**
     * Two or more people.
     * <p>Often the members are natural people, but they don't have to be.</p>
     * <p>They may be a couple, married, brothers and sisters etc.</p>
     * <p>Example: "Peter and Petra Smith".</p>
     * <p>When parsing names from addresses then the people in the group may also be unrelated, eg c/o addresses.</p>
     */
    MULTIPLE,
    ;



    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int size) {
        assert values().length==size : "Update the code calling PersonType.assertSize() with outdated "+size+" instead of "+values().length+"!";
    }

}
