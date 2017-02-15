package org.nameapi.ontology5.output.entities.person;

/**
 * This enum will be replaced by {@link MailingPersonRole}.
 *
 * @author Nicole Torres
 * @author Fabian Kessler
 */
@Deprecated
public enum PersonRole {

    /**
     * No role, it's just for grouping.
     */
    GROUP,

    /**
     * In most cases that's the value.
     */
    PRIMARY,

    /**
     * Beispiele: "Apotheke Müller z.H. Anna Meyer" (für Anna Meyer)
     */
    RECEIVER,

    /**
     * Beispiele: "Anna Meyer bei Petra Müller" (für Petra Müller)
     * The address.
     */
    RESIDENT,

    /**
     * reserved value (no example yet)
     */
    CONTACT,

    /**
     * Beispiele: "Apotheke Müller, Inh. Peter Meyer" (für Peter Meyer)
     */
    OWNER,

    /**
     * Beispiele: "Familie Peter Müller" (für Peter Müller)
     */
    MEMBER,
    ;


}
