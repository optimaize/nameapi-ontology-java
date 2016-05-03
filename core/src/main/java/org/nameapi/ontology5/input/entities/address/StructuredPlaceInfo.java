package org.nameapi.ontology5.input.entities.address;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;
import org.nameapi.ontology5.util.ValueTransformerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicole Torres
 */
public class StructuredPlaceInfo implements PlaceInfo {

    @NotNull
    private final Optional<String> locality;
    @NotNull
    private final Optional<String> postalCode;
    @NotNull
    private final Optional<String> neighborhood;
    @NotNull
    private final Optional<String> region;
    @NotNull
    private final Optional<String> country;

    @JsonCreator
    public StructuredPlaceInfo(
            @JsonProperty("locality") @NotNull Optional<String> locality, @JsonProperty("postalCode") @NotNull Optional<String> postalCode,
            @JsonProperty("neighborhood") @NotNull Optional<String> neighborhood,
            @JsonProperty("region") @NotNull Optional<String> region, @JsonProperty("country") @NotNull Optional<String> country) {
        if (!locality.isPresent() && !postalCode.isPresent() && !neighborhood.isPresent() && !region.isPresent() && !country.isPresent()) {
            throw new IllegalArgumentException("At least one value must be available!");
        }

        this.locality = locality;
        this.postalCode = postalCode;
        this.neighborhood = neighborhood;
        this.region = region;
        this.country = country;
    }


    @JsonIgnore
    @NotNull
    @Override
    public String getAsString() {
        String s = "";

        if (postalCode.isPresent()) {
            if (!s.isEmpty()) s += ", ";
            s += postalCode.get();
        }

        if (locality.isPresent()) {
            if (!s.isEmpty()) s += ", ";
            s += locality.get();
        }

        if (neighborhood.isPresent()) {
            if (!s.isEmpty()) s += ", ";
            s += neighborhood.get();
        }

        if (region.isPresent()) {
            if (!s.isEmpty()) s += ", ";
            s += region.get();
        }

        if (country.isPresent()) {
            if (!s.isEmpty()) s += ", ";
            s += country.get();
        }

        return s;
    }

    @JsonIgnore
    @NotNull
    @Override
    public List<String> getAsLines() {
        List<String> lines = new ArrayList<>(3);

        Optional<String> localityAndPostalCode = getLocalityAndPostalCode();
        if (localityAndPostalCode.isPresent()) {
            lines.add(localityAndPostalCode.get());
        } else if (postalCode.isPresent()) {
            lines.add(postalCode.get());
        } else if (locality.isPresent()) {
            lines.add(locality.get());
        }

        if (neighborhood.isPresent()) {
            lines.add(neighborhood.get());
        }
        if (region.isPresent()) {
            lines.add(region.get());
        }
        if (country.isPresent()) {
            lines.add(country.get());
        }

        return lines;
    }

    @JsonIgnore
    @NotNull
    @Override
    public Optional<String> getLocalityAndPostalCode() {
        if (locality.isPresent() && postalCode.isPresent()) {
            return Optional.of(postalCode.get()+" "+locality.get());
        } else {
            return Optional.absent();
        }
    }



    @Override
    @NotNull
    public Optional<String> getLocality() {
        return locality;
    }

    @Override
    @NotNull
    public Optional<String> getPostalCode() {
        return postalCode;
    }

    @Override
    @NotNull
    public Optional<String> getNeighborhood() {
        return neighborhood;
    }

    @Override
    @NotNull
    public Optional<String> getRegion() {
        return region;
    }

    @Override
    @NotNull
    public Optional<String> getCountry() {
        return country;
    }

    @Nullable
    @Override
    public PlaceInfo transform(@NotNull ValueTransformer transformer) {
        Optional<String> modLocality = ValueTransformerUtil.transformOptionalStringField(transformer, locality);
        Optional<String> modPostalCode = ValueTransformerUtil.transformOptionalStringField(transformer, postalCode);
        Optional<String> modNeighborhood = ValueTransformerUtil.transformOptionalStringField(transformer, neighborhood);
        Optional<String> modRegion = ValueTransformerUtil.transformOptionalStringField(transformer, region);
        Optional<String> modCountry = ValueTransformerUtil.transformOptionalStringField(transformer, country);

        if (ValueTransformerUtil.allAbsent(modLocality, modPostalCode, modNeighborhood, modRegion, modCountry)) {
            return null;
        }
        return new StructuredPlaceInfo(modLocality, modPostalCode, modNeighborhood, modRegion, modCountry);
    }

    @Override
    public String toString() {
        String s = "SegregatedPlaceInfo{";
        if (locality.isPresent()) s += "locality=" + locality.get();
        if (postalCode.isPresent()) s += ", postalCode=" + postalCode.get();
        if (neighborhood.isPresent()) s += ", neighborhood=" + neighborhood.get();
        if (region.isPresent()) s += ", region=" + region.get();
        if (country.isPresent()) s += ", country=" + country.get();
        s += '}';
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StructuredPlaceInfo that = (StructuredPlaceInfo) o;

        if (!locality.equals(that.locality)) return false;
        if (!postalCode.equals(that.postalCode)) return false;
        if (!neighborhood.equals(that.neighborhood)) return false;
        if (!region.equals(that.region)) return false;
        return country.equals(that.country);

    }

    @Override
    public int hashCode() {
        int result = locality.hashCode();
        result = 31 * result + postalCode.hashCode();
        result = 31 * result + neighborhood.hashCode();
        result = 31 * result + region.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }
}
