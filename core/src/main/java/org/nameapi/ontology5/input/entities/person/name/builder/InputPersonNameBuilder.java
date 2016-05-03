package org.nameapi.ontology5.input.entities.person.name.builder;

import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;
import org.nameapi.ontology5.input.entities.person.name.NameField;
import org.nameapi.ontology5.input.entities.person.name.types.CommonNameFieldType;

import java.util.ArrayList;
import java.util.List;

/**
 * ...
 *
 * @author aa
 */
public class InputPersonNameBuilder {

    @NotNull
    private final List<NameField> nameFields;

    public InputPersonNameBuilder() {
        nameFields = new ArrayList<>(6);
    }
    /**
     * Copy constructor.
     */
    public InputPersonNameBuilder(@NotNull InputPersonNameBuilder builder) {
        this(builder.nameFields);
    }
    /**
     * Copy constructor.
     * @param nameFields A copy is made.
     */
    public InputPersonNameBuilder(@NotNull List<NameField> nameFields) {
        this.nameFields = new ArrayList<>(nameFields);
    }


    @NotNull
    public InputPersonNameBuilder fullname(@NotNull String s) {
        return nameField(new NameField(s, CommonNameFieldType.FULLNAME));
    }


    @NotNull
    public InputPersonNameBuilder nameField(@NotNull NameField nameField) {
        nameFields.add(nameField);
        return this;
    }


    public boolean isEmpty() {
        return nameFields.isEmpty();
    }

    @NotNull
    public InputPersonName build() {
        return new InputPersonName(nameFields);
    }

}
