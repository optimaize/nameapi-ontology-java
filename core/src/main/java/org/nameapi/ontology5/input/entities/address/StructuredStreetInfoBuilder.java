package org.nameapi.ontology5.input.entities.address;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Builder for a {@link StructuredStreetInfo}.
 *
 * <p>The setters throw {@link IllegalStateException} in case a variable has been set already. This is to
 * make the developer aware of programming logic errors.</p>
 *
 * <p>The setters trim the string values, and empty strings are converted to <code>null</code>.</p>
 *
 * @author Nicole Torres
 */
public class StructuredStreetInfoBuilder {

    private String streetName;
    private String streetNumber;
    private String building;
    private String staircase;
    private String floor;
    private String apartment;


    @NotNull
    public StructuredStreetInfoBuilder streetName(@Nullable String streetName) {
        if (this.streetName !=null) throw new IllegalStateException("Set already!");
        this.streetName = clean(streetName);
        return this;
    }

    @NotNull
    public StructuredStreetInfoBuilder streetNumber(@Nullable String streetNumber) {
        if (this.streetNumber !=null) throw new IllegalStateException("Set already!");
        this.streetNumber = clean(streetNumber);
        return this;
    }

    @NotNull
    public StructuredStreetInfoBuilder building(@Nullable String building) {
        if (this.building !=null) throw new IllegalStateException("Set already!");
        this.building = clean(building);
        return this;
    }

    @NotNull
    public StructuredStreetInfoBuilder staircase(@Nullable String staircase) {
        if (this.staircase!=null) throw new IllegalStateException("Set already!");
        this.staircase = clean(staircase);
        return this;
    }
    @NotNull
    public StructuredStreetInfoBuilder floor(@Nullable String floor) {
        if (this.floor!=null) throw new IllegalStateException("Set already!");
        this.floor = clean(floor);
        return this;
    }

    @NotNull
    public StructuredStreetInfoBuilder apartment(@Nullable String apartment) {
        if (this.apartment!=null) throw new IllegalStateException("Set already!");
        this.apartment = clean(apartment);
        return this;
    }

    /**
     * @see #buildOrNull()
     * @throws IllegalStateException If streetName is <code>null</code>.
     */
    @NotNull
    public StructuredStreetInfo build() throws IllegalStateException {
        if (allNull()) {
            throw new IllegalStateException("At least one field must be available!");
        }
        return _build();
    }

    private boolean allNull() {
        return streetName==null && streetNumber==null && building==null && staircase==null && floor==null && apartment==null;
    }

    private StructuredStreetInfo _build() {
        return new StructuredStreetInfo(
                Optional.fromNullable(streetName),
                Optional.fromNullable(streetNumber),
                Optional.fromNullable(building),
                Optional.fromNullable(staircase),
                Optional.fromNullable(floor),
                Optional.fromNullable(apartment)
        );
    }

    /**
     * @see #build()
     * @return The new object, or <code>null</code> if all values were null, for example because no setter was called
     *         or all calls were ignored because of null or empty values.
     */
    @Nullable
    public StructuredStreetInfo buildOrNull() {
        if (streetName==null) return null;
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
