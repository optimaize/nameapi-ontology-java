package org.nameapi.ontology5.input.context;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Tells whether someone (a human or a program) is waiting for the answer or not.
 *
 * @author aa
 */
public enum Priority {

    /**
     * Another program, process or human is actively waiting for the answer, and needs it ASAP.
     *
     * <p>Requests are usually processed and answered within 500ms. NameAPI tries to always stay below 1000ms.
     * In certain scenarios it is possible that the server takes shortcuts and does not compute every detail in
     * order to keep the response time reasonable and practical.</p>
     */
    REALTIME,

    /**
     * Well suited for background and batch processing and therefore the response time from the server is non-critical.
     *
     * <p>Usually the response time is the same as for {@link #REALTIME}, however, the target response time goes
     * up to 10 seconds.</p>
     */
    LOW,
    ;


    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int size) {
        assert values().length == size : "Update the code that calls this with outdated size "+size+"!";
    }

    @JsonCreator
    public static Priority forValue(String value) {
        return Priority.valueOf(value.toUpperCase().trim());
    }

}
