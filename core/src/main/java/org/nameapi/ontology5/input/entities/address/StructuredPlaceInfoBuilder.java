package org.nameapi.ontology5.input.entities.address;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Builder for a {@link StructuredPlaceInfo}.
 *
 * <p>The setters throw {@link IllegalStateException} in case a variable has been set already. This is to
 * make the developer aware of programming logic errors.</p>
 *
 * <p>The setters trim the string values, and empty strings are converted to <code>null</code>.</p>
 *
 * @author Nicole Torres
 */
public class StructuredPlaceInfoBuilder {

    @Nullable
    private String locality;
    @Nullable
    private String postalCode;
    @Nullable
    private String neighborhood;
    @Nullable
    private String region;
    @Nullable
    private String country;


    @NotNull
    public StructuredPlaceInfoBuilder locality(@Nullable String locality) {
        if (this.locality !=null) throw new IllegalStateException("Set already!");
        this.locality = clean(locality);
        return this;
    }

    @NotNull
    public StructuredPlaceInfoBuilder postalCode(@Nullable String postalCode) {
        if (this.postalCode !=null) throw new IllegalStateException("Set already!");
        this.postalCode = clean(postalCode);
        return this;
    }

    @NotNull
    public StructuredPlaceInfoBuilder neighborhood(@Nullable String neighborhood) {
        if (this.neighborhood !=null) throw new IllegalStateException("Set already!");
        this.neighborhood = clean(neighborhood);
        return this;
    }

    @NotNull
    public StructuredPlaceInfoBuilder region(@Nullable String region) {
        if (this.region!=null) throw new IllegalStateException("Set already!");
        this.region = clean(region);
        return this;
    }
    @NotNull
    public StructuredPlaceInfoBuilder country(@Nullable String country) {
        if (this.country!=null) throw new IllegalStateException("Set already!");
        this.country = clean(country);
        return this;
    }

    /**
     * @see #buildOrNull()
     * @throws IllegalStateException If all fields are <code>null</code>, either because no setter was called at all
     *         or because setters were only called with <code>null</code> or empty values. Don't create an address
     *         at all if no information is available.
     */
    @NotNull
    public StructuredPlaceInfo build() throws IllegalStateException {
        if (allNull()) throw new IllegalStateException("All fields are null!");
        return _build();
    }
    private StructuredPlaceInfo _build() {
        return new StructuredPlaceInfo(
                Optional.fromNullable(locality),
                Optional.fromNullable(postalCode),
                Optional.fromNullable(neighborhood),
                Optional.fromNullable(region),
                Optional.fromNullable(country)
        );
    }

    /**
     * @see #build()
     * @return The new object, or <code>null</code> if all values were null, for example because no setter was called
     *         or all calls were ignored because of null or empty values.
     */
    @Nullable
    public StructuredPlaceInfo buildOrNull() {
        if (allNull()) return null;
        return _build();
    }


    @Nullable
    private String clean(@Nullable String stringValue) {
        if (stringValue==null) return null;
        stringValue = stringValue.trim();
        if (stringValue.isEmpty()) return null;
        return stringValue;
    }

    private boolean allNull() {
        return locality ==null && postalCode==null && neighborhood==null && region==null && country==null;
    }

}
