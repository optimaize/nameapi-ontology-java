package org.nameapi.ontology5.input.entities.person.name;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import org.nameapi.ontology5.cremalang.annotation.GeneratedCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a person's names such as given name(s) and surname(s).
 *
 * <p>Multiple given names may appear in one field. Or they can be added as multiple name items if
 * they are available separately already. The same applies for other name types such as surnames.</p>
 *
 * @author sam
 */
public class InputPersonName {

    @NotNull
    private final List<NameField> nameFields;


    /**
     * @param nameFields May be empty.
     */
    @JsonCreator
    public InputPersonName(
            @JsonProperty("nameFields") @NotNull List<NameField> nameFields
    ) {
        this.nameFields = ImmutableList.copyOf(nameFields);
    }

    /**
     * @return May be empty.
     */
    @NotNull
    public List<NameField> getNameFields() {
        return nameFields;
    }

    @NotNull
    public Optional<NameField> getFirst(@NotNull FieldType fieldType) {
        for (NameField nameField : nameFields) {
            if (nameField.getFieldType()==fieldType) return Optional.of(nameField);
        }
        return Optional.absent();
    }

    @NotNull
    public Optional<NameField> getSecond(@NotNull FieldType fieldType) {
        boolean had = false;
        for (NameField nameField : nameFields) {
            if (nameField.getFieldType()==fieldType) {
                if (had) {
                    return Optional.of(nameField);
                } else {
                    had = true;
                }
            }
        }
        return Optional.absent();
    }

    @Nullable
    public InputPersonName transform(@NotNull ValueTransformer transformer) {
        List<NameField> copy = new ArrayList<>(nameFields.size());
        for (NameField nameField : nameFields) {
            NameField modified = nameField.transform(transformer);
            if (modified!=null) {
                copy.add(modified);
            }
        }
        if (copy.isEmpty()) return null;
        return new InputPersonName(copy);
    }


    @Override @GeneratedCode
    public String toString() {
        return "InputPersonNameImpl{" +
                "fields=" + nameFields +
                '}';
    }

    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputPersonName that = (InputPersonName) o;

        if (!nameFields.equals(that.nameFields)) return false;

        return true;
    }

    @Override @GeneratedCode
    public int hashCode() {
        return nameFields.hashCode();
    }

}
