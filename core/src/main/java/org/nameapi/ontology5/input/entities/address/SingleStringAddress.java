package org.nameapi.ontology5.input.entities.address;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

import java.util.Collections;
import java.util.List;

/**
 * Address impl where the address is in one single line.
 *
 * <p>Specific data such as street name and post code are not known, they need
 * to be parsed/extracted.</p>
 *
 * <p>Such unstructured address data may exist for example from a single text
 * input field (not textarea). If you have a textarea with line breaks then
 * split the input by new line and use the {@link MultiLineAddress}.</p>
 *
 * <p>The information in the string may for example be separated by comma.
 * It is up to the service that uses this data to detect and parse/extract.</p>
 *
 * @author sam
 */
public class SingleStringAddress extends BasePlaintextAddress implements InputAddress {

    @NotNull
    private final String string;

    /**
     * @param string May not be empty nor contain line breaks.
     * @throws IllegalArgumentException If the input is empty, or contains line breaks.
     */
    @JsonCreator
    public SingleStringAddress(
            @JsonProperty("string") @JsonPropertyDescription("The address information that appears in one single line.") @NotNull String string) {
        if (string.isEmpty()) throw new IllegalArgumentException("May not be empty!");
        if (string.contains("\n")) throw new IllegalArgumentException("Line breaks are not allowed!");
        this.string = string;
    }

    @NotNull
    public String getString() {
        return string;
    }

    @JsonIgnore
    @NotNull
    public List<String> getAddressLines() {
        return Collections.singletonList(string);
    }

    @JsonIgnore
    @NotNull
    @Override
    public Optional<PlaceInfo> getPlaceInfo() {
        return Optional.absent();
    }

    @Nullable
    @Override
    public SingleStringAddress transform(@NotNull ValueTransformer transformer) {
        String modified = transformer.transform(string);
        if (modified==null || modified.isEmpty()) return null;
        if (string.equals(modified)) return this;
        return new SingleStringAddress(modified);
    }

}
