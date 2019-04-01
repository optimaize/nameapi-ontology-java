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
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Specifies for what purposes a certain {@link InputAddress} is, for example for {@link AddressUsage#CORRESPONDENCE}.
 *
 * @author sam
 */
public class SpecificUsageAddressRelation implements AddressRelation {

    @NotNull
    private final InputAddress address;
    @NotNull
    private final Set<AddressUsage> usage;

    @JsonCreator
    public SpecificUsageAddressRelation(
            @JsonProperty("address") @JsonPropertyDescription("Represents a physical address which can be an address to a house, a postbox, a \"packet pickup station\" etc.") @NotNull InputAddress address,
            @JsonProperty("usage") @JsonPropertyDescription("Lists the possible purposes of an input address.\nSee https://goo.gl/uap11n for the documentation of the AddressUsage enum values. ") @NotNull Set<AddressUsage> usage
    ) {
        this.address = address;
        this.usage   = usage;
    }
    public SpecificUsageAddressRelation(@NotNull InputAddress address, @NotNull AddressUsage... usage) {
        this.address = address;
        this.usage = new LinkedHashSet<>();
        Collections.addAll(this.usage, usage);
    }

    @NotNull @Override
    public InputAddress getAddress() {
        return address;
    }

    @Nullable
    @Override
    public AddressRelation transform(@NotNull ValueTransformer transformer) {
        InputAddress modAddress = address.transform(transformer);
        if (modAddress == null) {
            return null;
        }
        if (modAddress.equals(address)) {
            return this;
        }
        return new SpecificUsageAddressRelation(modAddress, usage);
    }

    @JsonIgnore
    @Override
    public boolean isUsageForAll() {
        return false;
    }

    @NotNull @Override
    public Optional<Set<AddressUsage>> getSpecificUsage() {
        return Optional.of(usage);
    }

    @Override
    public String toString() {
        return "SpecificUsageAddressRelation{" +
                "address=" + address +
                ", usage=" + usage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecificUsageAddressRelation that = (SpecificUsageAddressRelation) o;

        if (!address.equals(that.address)) return false;
        return usage.equals(that.usage);

    }

    @Override
    public int hashCode() {
        int result = address.hashCode();
        result = 31 * result + usage.hashCode();
        return result;
    }
}
