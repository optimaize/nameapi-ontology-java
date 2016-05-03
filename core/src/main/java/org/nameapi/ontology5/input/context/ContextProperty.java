package org.nameapi.ontology5.input.context;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

/**
 * One named property within {@link ContextProperties}.
 *
 * <p>The value of a property is always of type String.
 * The ContextProperties class provides methods for working with these values.</p>
 *
 * @author Gabriela Achim
 */
@Immutable
public class ContextProperty {

    @NotNull
    private final String name;

    @NotNull
    private final String value;

    @JsonCreator
    public ContextProperty(
            @JsonProperty("name") @NotNull String name,
            @JsonProperty("value") @NotNull String value
    ) {
        this.name = name;
        this.value = value;
    }


    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getValue() {
        return value;
    }

    @Nullable
    public ContextProperty transform(@NotNull ValueTransformer transformer) {
        String modifiedName = transformer.transform(name);
        if (modifiedName==null || modifiedName.isEmpty()) return null;

        String modifiedValue = transformer.transform(value);
        if (modifiedValue==null || modifiedValue.isEmpty()) return null;

        if (name.equals(modifiedName) && value.equals(modifiedValue)) return this;
        return new ContextProperty(modifiedName, modifiedValue);
    }

}
