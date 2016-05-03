package org.nameapi.ontology5.input.entities.address;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

/**
 * Impl where the whole street/house etc information is in plaintext form in a
 * single line and needs to be parsed to extract information.
 *
 * <p>It contains at least a street name, but may contain all other kinds of information also such as
 * apartment/suite etc.</p>
 *
 * @author sam
 */
public class SingleStringStreetInfo extends BaseStreetInfo {

    @NotNull
    private final String string;

    @JsonCreator
    public SingleStringStreetInfo(
            @JsonProperty("string") @NotNull String string) {
        this.string = string;
    }

    /**
     * Same as {@link #getAsString()}, for JSON marshalling.
     */
    @NotNull
    public String getString() {
        return getAsString();
    }

    @JsonIgnore
    @NotNull @Override
    public String getAsString() {
        return string;
    }

    @Nullable
    @Override
    public StreetInfo transform(@NotNull ValueTransformer transformer) {
        String modified = transformer.transform(string);
        if (modified==null || modified.isEmpty()) return null;
        if (string.equals(modified)) return this;
        return new SingleStringStreetInfo(modified);
    }


    @Override
    public String toString() {
        return "SingleStringStreetInfo{" +
                "string='" + string + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleStringStreetInfo that = (SingleStringStreetInfo) o;

        return string.equals(that.string);

    }

    @Override
    public int hashCode() {
        return string.hashCode();
    }
}
