package org.nameapi.ontology5.input.entities.address;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;
import org.nameapi.ontology5.util.ValueTransformerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * An address where the individual parts (street name, postal code, ...) are structured into separate values.
 *
 * This address works for all countries.
 *
 * @see StructuredAddressBuilder
 * @author Nicole Torres
 */
@Immutable
public class StructuredAddress implements InputAddress {

    @NotNull
    protected final Optional<StreetInfo> streetInfo;
    @NotNull
    private final Optional<String> pobox;
    @NotNull
    protected final Optional<PlaceInfo> placeInfo;


    /**
     * Use the {@link StructuredAddressBuilder}, not this constructor directly.
     */
    @JsonCreator
    public StructuredAddress(
            @JsonProperty("streetInfo") @NotNull Optional<StreetInfo> streetInfo,
            @JsonProperty("pobox") @NotNull Optional<String> pobox,
            @JsonProperty("placeInfo") @NotNull Optional<PlaceInfo> placeInfo
    ) {
        if (!streetInfo.isPresent() && !pobox.isPresent() && !placeInfo.isPresent()) {
            throw new IllegalArgumentException("At least one value must be available!");
        }
        this.streetInfo = streetInfo;
        this.pobox = pobox;
        this.placeInfo = placeInfo;
    }

    @JsonIgnore
    @NotNull @Override
    public List<String> getAddressLines() {
        List<String> ret = new ArrayList<>();
        if (streetInfo.isPresent()) {
            for (String s : streetInfo.get().getAsLines()) {
                if (!s.isEmpty()) ret.add(s);
            }
        }
        if (pobox.isPresent()) {
            ret.add(pobox.get()); //TODO possibly add "Postbox" or something in front? Otherwise one does not know what that number is for.
        }

        if (placeInfo.isPresent()) {
            for (String s : placeInfo.get().getAsLines()) {
                if (!s.isEmpty()) ret.add(s);
            }
        }

        return ret;
    }

//    @Override
//    public boolean isPlaintextAddress() {
//        return false;
//    }



    @NotNull @Override
    public Optional<StreetInfo> getStreetInfo() {
        return streetInfo;
    }

    @NotNull @Override
    public Optional<String> getPobox() {
        return pobox;
    }

    @NotNull @Override
    public Optional<PlaceInfo> getPlaceInfo() {
        return placeInfo;
    }

    @Nullable
    @Override
    public InputAddress transform(@NotNull ValueTransformer transformer) {
        Optional<StreetInfo> modStreetInfo = Optional.absent();
        if (streetInfo.isPresent()) {
            modStreetInfo = Optional.fromNullable(streetInfo.get().transform(transformer));
        }

        Optional<String> modPobox = ValueTransformerUtil.transformOptionalStringField(transformer, pobox);

        Optional<PlaceInfo> modPlaceInfo = Optional.absent();
        if (placeInfo.isPresent()) {
            modPlaceInfo = Optional.fromNullable(placeInfo.get().transform(transformer));
        }

        if (!modStreetInfo.isPresent() && !modPobox.isPresent() && !modPlaceInfo.isPresent()) {
            return null;
        }
        return new StructuredAddress(modStreetInfo, modPobox, modPlaceInfo);
    }


    @Override
    public String toString() {
        String s = "StructuredAddress{";
        s += "streetInfo=" + streetInfo;
        if (pobox.isPresent()) s += ", pobox=" + pobox.get();
        s += ", placeInfo=" + placeInfo;
        s += '}';
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StructuredAddress that = (StructuredAddress) o;

        if (!streetInfo.equals(that.streetInfo)) return false;
        if (!pobox.equals(that.pobox)) return false;
        return placeInfo.equals(that.placeInfo);

    }

    @Override
    public int hashCode() {
        int result = streetInfo.hashCode();
        result = 31 * result + pobox.hashCode();
        result = 31 * result + placeInfo.hashCode();
        return result;
    }

}
