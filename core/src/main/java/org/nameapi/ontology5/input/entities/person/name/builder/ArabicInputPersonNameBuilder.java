package org.nameapi.ontology5.input.entities.person.name.builder;

import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.input.entities.person.name.FieldType;
import org.nameapi.ontology5.input.entities.person.name.NameField;
import org.nameapi.ontology5.input.entities.person.name.types.ArabicNameFieldType;
import org.nameapi.ontology5.input.entities.person.name.types.CommonNameFieldType;

/**
 * ...
 *
 * @author aa
 */
public class ArabicInputPersonNameBuilder extends InputPersonNameBuilder {

    @NotNull
    public ArabicInputPersonNameBuilder fullname(@NotNull String s) {
        return add(s, CommonNameFieldType.FULLNAME);
    }

    @NotNull
    public ArabicInputPersonNameBuilder ism(@NotNull String s) {
        return add(s, ArabicNameFieldType.ISM);
    }
    @NotNull
    public ArabicInputPersonNameBuilder kunya(@NotNull String s) {
        return add(s, ArabicNameFieldType.KUNYA);
    }
    @NotNull
    public ArabicInputPersonNameBuilder nasab(@NotNull String s) {
        return add(s, ArabicNameFieldType.NASAB);
    }
    @NotNull
    public ArabicInputPersonNameBuilder laqab(@NotNull String s) {
        return add(s, ArabicNameFieldType.LAQAB);
    }
    @NotNull
    public ArabicInputPersonNameBuilder nisbah(@NotNull String s) {
        return add(s, ArabicNameFieldType.NISBAH);
    }


    private ArabicInputPersonNameBuilder add(String s, FieldType fieldType) {
        super.nameField(new NameField(s, fieldType));
        return this;
    }

}
