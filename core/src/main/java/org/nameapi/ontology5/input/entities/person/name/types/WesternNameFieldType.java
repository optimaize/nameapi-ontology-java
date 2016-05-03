package org.nameapi.ontology5.input.entities.person.name.types;

import org.nameapi.ontology5.input.entities.person.name.FieldType;

/**
 * ...
 *
 */
public enum WesternNameFieldType implements FieldType {

    //Currently no values here, they all fit into CommonNameFieldType

    ;

    @Override
    public Enum getEnum() {
        return this;
    }
}
