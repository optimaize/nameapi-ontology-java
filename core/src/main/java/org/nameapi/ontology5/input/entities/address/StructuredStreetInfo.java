package org.nameapi.ontology5.input.entities.address;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;
import org.nameapi.ontology5.util.ValueTransformerUtil;

import java.util.Collections;
import java.util.List;

/**
 * @author Nicole Torres
 */
public class StructuredStreetInfo implements StreetInfo {

    @NotNull
    private final Optional<String> streetName;
    @NotNull
    private final Optional<String> streetNumber;
    @NotNull
    private final Optional<String> building;
    @NotNull
    private final Optional<String> staircase;
    @NotNull
    private final Optional<String> floor;
    @NotNull
    private final Optional<String> apartment;

    @JsonCreator
    public StructuredStreetInfo(@JsonProperty("streetName") @NotNull Optional<String> streetName,
                                @JsonProperty("streetNumber") @NotNull Optional<String> streetNumber,
                                @JsonProperty("building") @NotNull Optional<String> building,
                                @JsonProperty("staircase") @NotNull Optional<String> staircase,
                                @JsonProperty("floor") @NotNull Optional<String> floor,
                                @JsonProperty("apartment") @NotNull Optional<String> apartment) {
        if (ValueTransformerUtil.allAbsent(streetName, streetNumber, building, staircase, floor, apartment)) {
            throw new IllegalArgumentException("At least one value must be available!");
        }
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.building = building;
        this.staircase = staircase;
        this.floor = floor;
        this.apartment = apartment;
    }

    @JsonIgnore
    @NotNull
    @Override
    public String getAsString() {
        StringBuilder sb = new StringBuilder();

        sb.append(makeStreetAndNumber());

        Optional<String> addressLine2 = getAddressLine2();
        if (addressLine2.isPresent()) {
            sb.append(", ");
            sb.append(addressLine2.get());
        }

        return sb.toString();
    }

    @JsonIgnore
    @NotNull
    @Override
    public List<String> getAsLines() {
        Optional<String> addressLine2 = getAddressLine2();
        if (addressLine2.isPresent()) {
            return ImmutableList.of(
                    makeStreetAndNumber(),
                    addressLine2.get()
            );
        } else {
            return Collections.singletonList(makeStreetAndNumber());
        }
    }

    private String makeStreetAndNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(streetName);
        if (streetNumber.isPresent()) {
            sb.append(" "+streetNumber.get());
        }
        return sb.toString();
    }

    @JsonIgnore
    @NotNull
    @Override
    public Optional<String> getStreetNameAndNumber() {
        return Optional.of(makeStreetAndNumber());
    }

    @JsonIgnore
    @NotNull
    @Override
    public Optional<String> getAddressLine2() {
        if (building.isPresent() || staircase.isPresent() || floor.isPresent() || apartment.isPresent()) {
            String s = "";
            if (building.isPresent()) {
                s += "Bl. "+building.get();
            }
            if (staircase.isPresent()) {
                if (!s.isEmpty()) s += ", ";
                s += "Sc. "+staircase.get();
            }
            if (floor.isPresent()) {
                if (!s.isEmpty()) s += ", ";
                s += "Fl. "+floor.get();
            }
            if (apartment.isPresent()) {
                if (!s.isEmpty()) s += ", ";
                s += "Ap. "+apartment.get();
            }
            return Optional.of(s);
        } else {
            return Optional.absent();
        }
    }

    @Override
    @NotNull
    public Optional<String> getStreetName() {
        return streetName;
    }

    @Override
    @NotNull
    public Optional<String> getStreetNumber() {
        return streetNumber;
    }

    @Override
    @NotNull
    public Optional<String> getBuilding() {
        return building;
    }

    @Override
    @NotNull
    public Optional<String> getStaircase() {
        return staircase;
    }

    @Override
    @NotNull
    public Optional<String> getFloor() {
        return floor;
    }

    @Override
    @NotNull
    public Optional<String> getApartment() {
        return apartment;
    }

    @Nullable
    @Override
    public StreetInfo transform(@NotNull ValueTransformer transformer) {
        Optional<String> modStreet = ValueTransformerUtil.transformOptionalStringField(transformer, streetName);
        Optional<String> modStreetNumber = ValueTransformerUtil.transformOptionalStringField(transformer, streetNumber);
        Optional<String> modBuilding = ValueTransformerUtil.transformOptionalStringField(transformer, building);
        Optional<String> modStaircase = ValueTransformerUtil.transformOptionalStringField(transformer, staircase);
        Optional<String> modFloor = ValueTransformerUtil.transformOptionalStringField(transformer, floor);
        Optional<String> modApartment = ValueTransformerUtil.transformOptionalStringField(transformer, apartment);

        if (ValueTransformerUtil.allAbsent(modStreet, modStreetNumber, modBuilding, modStaircase, modFloor, modApartment)) {
            return null;
        }
        return new StructuredStreetInfo(modStreet, modStreetNumber, modBuilding, modStaircase, modFloor, modApartment);
    }


    @Override
    public String toString() {
        String s = "SegregatedStreetInfo{";
        s += "streetName='" + streetName + '\'';
        if (streetNumber.isPresent()) s += ", streetNumber=" + streetNumber.get();
        if (building.isPresent()) s += ", building=" + building.get();
        if (staircase.isPresent()) s += ", staircase=" + staircase.get();
        if (floor.isPresent()) s += ", floor=" + floor.get();
        if (apartment.isPresent()) s += ", apartment=" + apartment.get();
        s += '}';
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StructuredStreetInfo that = (StructuredStreetInfo) o;

        if (!streetName.equals(that.streetName)) return false;
        if (!streetNumber.equals(that.streetNumber)) return false;
        if (!building.equals(that.building)) return false;
        if (!staircase.equals(that.staircase)) return false;
        if (!floor.equals(that.floor)) return false;
        return apartment.equals(that.apartment);

    }

    @Override
    public int hashCode() {
        int result = streetName.hashCode();
        result = 31 * result + streetNumber.hashCode();
        result = 31 * result + building.hashCode();
        result = 31 * result + staircase.hashCode();
        result = 31 * result + floor.hashCode();
        result = 31 * result + apartment.hashCode();
        return result;
    }

}
