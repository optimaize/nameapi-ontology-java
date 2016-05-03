package org.nameapi.ontology5.input.entities.address;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Address impl where the address lines only exist in the form of text lines.
 *
 * <p>Specific data such as street name and post code are not known, they need
 * to be parsed/extracted.</p>
 *
 * <p>Such unstructured address data exists in legacy systems. It works
 * well for delivery, but has no semantic meaning before parsing.</p>
 *
 * @author sam
 */
public class MultiLineAddress extends BasePlaintextAddress implements InputAddress {

    @NotNull
    private final List<String> addressLines;

    @JsonCreator
    public MultiLineAddress(
            @JsonProperty("addressLines") @NotNull List<String> addressLines) {
        if (addressLines.isEmpty()) throw new IllegalArgumentException("At least one line is required!");
        this.addressLines = ImmutableList.copyOf(addressLines);
    }
    public MultiLineAddress(@NotNull String firstLine, @NotNull String... moreLines) {
        List<String> addressLines = new ArrayList<>();
        addressLines.add(firstLine);
        Collections.addAll(addressLines, moreLines);
        this.addressLines = Collections.unmodifiableList(addressLines);
    }

    @NotNull
    public List<String> getAddressLines() {
        return addressLines;
    }

    @JsonIgnore
    @NotNull
    @Override
    public Optional<PlaceInfo> getPlaceInfo() {
        return Optional.absent();
    }

    @Nullable
    @Override
    public InputAddress transform(@NotNull ValueTransformer transformer) {
        List<String> copy = new ArrayList<>(addressLines.size());
        for (String addressLine : addressLines) {
            String modified = transformer.transform(addressLine);
            if (modified!=null && !modified.isEmpty()) {
                copy.add(modified);
            }
        }
        if (copy.isEmpty()) return null;
        return new MultiLineAddress(copy);
    }

}
