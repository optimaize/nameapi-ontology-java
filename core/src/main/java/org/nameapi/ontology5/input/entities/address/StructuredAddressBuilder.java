package org.nameapi.ontology5.input.entities.address;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Builder for a {@link StructuredAddress}.
 *
 * <p>The setters throw {@link IllegalStateException} in case a variable has been set already. This is to
 * make the developer aware of programming logic errors.</p>
 *
 * <p>The setters trim the string values, and empty strings are converted to <code>null</code>.</p>
 *
 * @author Nicole Torres
 */
public class StructuredAddressBuilder {

    @Nullable
    private StreetInfo streetInfo;
    @Nullable
    private String pobox;
    @Nullable
    private PlaceInfo placeInfo;


    @NotNull
    public StructuredAddressBuilder streetInfo(@Nullable StreetInfo streetInfo) {
        if (this.streetInfo!=null) throw new IllegalStateException("Set already!");
        this.streetInfo = streetInfo;
        return this;
    }
    @NotNull
    public StructuredAddressBuilder streetInfo(@NotNull StructuredStreetInfoBuilder streetInfo) {
        return streetInfo(streetInfo.build());
    }
    @NotNull
    public StructuredAddressBuilder pobox(@Nullable String pobox) {
        if (this.pobox !=null) throw new IllegalStateException("Set already!");
        this.pobox = clean(pobox);
        return this;
    }

    @NotNull
    public StructuredAddressBuilder placeInfo(@Nullable PlaceInfo placeInfo) {
        if (this.placeInfo !=null) throw new IllegalStateException("Set already!");
        this.placeInfo = placeInfo;
        return this;
    }
    @NotNull
    public StructuredAddressBuilder placeInfo(@NotNull StructuredPlaceInfoBuilder placeInfo) {
        return placeInfo(placeInfo.build());
    }

    /**
     * @see #buildOrNull()
     * @throws IllegalStateException If placeInfo is not set.
     */
    @NotNull
    public StructuredAddress build() throws IllegalStateException {
        if (placeInfo == null && pobox == null && streetInfo == null) throw new IllegalStateException("At least one value must be available!");
        return _build();
    }
    private StructuredAddress _build() {
        return new StructuredAddress(
                Optional.fromNullable(streetInfo),
                Optional.fromNullable(pobox),
                Optional.fromNullable(placeInfo));
    }

    /**
     * @see #build()
     * @return The new object, or <code>null</code> if there is no data.
     */
    @Nullable
    public StructuredAddress buildOrNull() {
        if (placeInfo == null && pobox == null && streetInfo == null) return null;
        return _build();
    }


    @Nullable
    private String clean(@Nullable String stringValue) {
        if (stringValue==null) return null;
        stringValue = stringValue.trim();
        if (stringValue.isEmpty()) return null;
        return stringValue;
    }

}
