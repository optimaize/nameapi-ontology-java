package org.nameapi.ontology5.input.entities.person.name.builder;

import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.input.entities.person.name.FieldType;
import org.nameapi.ontology5.input.entities.person.name.NameField;
import org.nameapi.ontology5.input.entities.person.name.types.CommonNameFieldType;

/**
 * ...
 *
 * @author aa
 */
public class WesternInputPersonNameBuilder extends InputPersonNameBuilder {

    @NotNull
    public WesternInputPersonNameBuilder fullname(@NotNull String s) {
        return add(s, CommonNameFieldType.FULLNAME);
    }

    @NotNull
    public WesternInputPersonNameBuilder givenName(@NotNull String s) {
        return add(s, CommonNameFieldType.GIVENNAME);
    }
    @NotNull
    public WesternInputPersonNameBuilder surname(@NotNull String s) {
        return add(s, CommonNameFieldType.SURNAME);
    }

    @NotNull
    public WesternInputPersonNameBuilder nameField(@NotNull NameField nameField) {
        super.nameField(nameField);
        return this;
    }


    private WesternInputPersonNameBuilder add(String s, FieldType fieldType) {
        super.nameField(new NameField(s, fieldType));
        return this;
    }

}
