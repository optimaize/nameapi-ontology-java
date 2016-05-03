package org.nameapi.ontology5.input.entities.contact;

import org.jetbrains.annotations.NotNull;

/**
 * Factory for making {@link org.nameapi.ontology5.input.entities.contact.TelNumber} instances.
 *
 * @author Nicole Torres
 */
public class TelNumberFactory {

    /**
     * @param fullNumber A single telephone number, for example "+33 3 86 30 77 88"
     */
    @NotNull
    public static TelNumber forNumber(@NotNull String fullNumber) {
        return new SimpleTelNumber(fullNumber);
    }

}
