package org.nameapi.ontology5.input.entities.person.name.builder;

/**
 * ...
 *
 * @author aa
 */
public class NameBuilders {

    public static WesternInputPersonNameBuilder western() {
        return new WesternInputPersonNameBuilder();
    }

    public static AmericanInputPersonNameBuilder american() {
        return new AmericanInputPersonNameBuilder();
    }

    public static ArabicInputPersonNameBuilder arabic() {
        return new ArabicInputPersonNameBuilder();
    }

    public static LegalInputPersonNameBuilder legal() {
        return new LegalInputPersonNameBuilder();
    }

}
