package org.nameapi.ontology5.input.entities.person.name;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

/**
 * An input field for a name or name-related input, such as a given name.
 *
 * @author sam
 */
@Immutable
public class NameField {

    @NotNull
    private final String string;
    @NotNull
    private final FieldType fieldType;

    public NameField(
            @NotNull String string,
            @NotNull FieldType fieldType
    ) {
        this.string = string;
        this.fieldType = fieldType;
    }
    @JsonCreator
    public NameField(
            @JsonProperty("string") @JsonPropertyDescription("The string on the input.") @NotNull String string,
            @JsonProperty("fieldType") @JsonPropertyDescription("<p>The field type, a common interface for the enum values.</p>") @NotNull String fieldType
    ) {
        this.string = string;
        this.fieldType = FieldTypes.valueOf(fieldType);
    }

    @Nullable
    public NameField transform(@NotNull ValueTransformer transformer) {
        String modified = transformer.transform(string);
        if (modified==null || modified.isEmpty()) return null;
        if (string.equals(modified)) return this;
        return new NameField(modified, fieldType);
    }

    @NotNull
    public String getString() {
        return string;
    }

    @NotNull
    public FieldType getFieldType() {
        return fieldType;
    }


    @Override
    public String toString() {
        return "Field{" +
                "string='" + string + '\'' +
                ", type=" + fieldType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NameField nameField = (NameField) o;

        if (fieldType != nameField.fieldType) return false;
        if (!string.equals(nameField.string)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = string.hashCode();
        result = 31 * result + fieldType.hashCode();
        return result;
    }
}
