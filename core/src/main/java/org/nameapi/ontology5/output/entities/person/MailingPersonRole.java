package org.nameapi.ontology5.output.entities.person;

/**
 * The roles of a person within a mailing address.
 * It is of interest once not only a single, but multiple entities are mentioned.
 *
 * @author Nicole Torres
 * @author Fabian Kessler
 */
public enum MailingPersonRole {

    /**
     * Multiple entities (people) grouped as one.
     * Examples:
     *   "John Doe and Jane Jackson"
     *   "John Doe c/o Jane Jackson"
     */
    GROUPING,

    /**
     * Aka recipient, the primary actor.
     *
     * Example: "John Doe c/o Jane Jackson"
     * John Doe is the recipient.
     *
     * The mail should not be opened by anyone else, see {@link #CONTACT}.
     */
    ADDRESSEE,

    /**
     * Example 1: "ACME Inc. attn. John Doe"
     * ACME Inc. is the resident.
     *
     * Example 2: "John Doe c/o Jane Jackson"
     * Jane Jackson is the resident.
     */
    RESIDENT,

    /**
     * Similar to recipient, but it's only a suggestion, not required legally (Postgeheimnis). See {@link #ADDRESSEE}.
     *
     * Example 1: "ACME Inc. attn. John Doe"
     * John Doe is the contact.
     *
     */
    CONTACT,

    /**
     * Example: "Apotheke Müller, proprietor Peter Meyer" (für Peter Meyer)
     * Peter Meyer is the owner.
     */
    OWNER,

    /**
     * Beispiele: "Familie Peter Müller" (für Peter Müller)
     */
    MEMBER,
    ;

    public static void assertSize(int size) {
        assert values().length==size : "Update the code calling MailingPersonRole.assertSize() with outdated "+size+" instead of "+values().length+"!";
    }

}
