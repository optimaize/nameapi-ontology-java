package org.nameapi.ontology5.input.entities.person.name.builder;

import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.input.entities.person.name.FieldType;
import org.nameapi.ontology5.input.entities.person.name.NameField;
import org.nameapi.ontology5.input.entities.person.name.types.AmericanNameFieldType;
import org.nameapi.ontology5.input.entities.person.name.types.CommonNameFieldType;

/**
 * ...
 *
 * @author aa
 */
public class AmericanInputPersonNameBuilder extends InputPersonNameBuilder {

    @NotNull
    public AmericanInputPersonNameBuilder fullname(@NotNull String s) {
        return add(s, CommonNameFieldType.FULLNAME);
    }

    @NotNull
    public AmericanInputPersonNameBuilder givenName(@NotNull String s) {
        return add(s, CommonNameFieldType.GIVENNAME);
    }
    @NotNull
    public AmericanInputPersonNameBuilder middleName(@NotNull String s) {
        return add(s, AmericanNameFieldType.MIDDLENAME);
    }
    @NotNull
    public AmericanInputPersonNameBuilder surname(@NotNull String s) {
        return add(s, CommonNameFieldType.SURNAME);
    }

    @NotNull
    public AmericanInputPersonNameBuilder prefix(@NotNull String s) {
        return add(s, AmericanNameFieldType.NAMEPREFIX);
    }
    @NotNull
    public AmericanInputPersonNameBuilder suffix(@NotNull String s) {
        return add(s, AmericanNameFieldType.NAMESUFFIX);
    }


    private AmericanInputPersonNameBuilder add(String s, FieldType fieldType) {
        super.nameField(new NameField(s, fieldType));
        return this;
    }

}
