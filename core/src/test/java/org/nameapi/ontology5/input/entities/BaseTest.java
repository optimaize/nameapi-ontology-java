package org.nameapi.ontology5.input.entities;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;
import org.nameapi.ontology5.input.entities.person.name.NameField;
import org.nameapi.ontology5.input.entities.person.name.types.CommonNameFieldType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriela Achim
 */
public class BaseTest {

    public ValueTransformer nullTransformer() {
        return new ValueTransformer() {
            @Nullable
            @Override
            public String transform(@NotNull String input) {
                return null;
            }
        };
    }

    public InputPersonName makeInputPesonName(String fullname) {
        List<NameField> nameFields = new ArrayList<>(1);
        nameFields.add(new NameField(fullname, CommonNameFieldType.FULLNAME));
        return new InputPersonName(nameFields);
    }
}
