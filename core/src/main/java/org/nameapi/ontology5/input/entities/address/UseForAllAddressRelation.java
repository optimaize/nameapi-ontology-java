package org.nameapi.ontology5.input.entities.address;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

import java.util.Set;

/**
 * An address relation that specifies that the address is used for all purposes.
 *
 * <p>This is the case when only one address is known from the {@link org.nameapi.ontology5.input.entities.person.InputPerson}.</p>
 *
 * @author sam
 */
public class UseForAllAddressRelation implements AddressRelation {

    @NotNull
    private final InputAddress address;

    @JsonCreator
    public UseForAllAddressRelation(
            @JsonProperty("address") @JsonPropertyDescription("Represents a physical address which can be an address to a house, a postbox, a \"packet pickup station\" etc.") @NotNull InputAddress address
    ) {
        this.address = address;
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
        return new UseForAllAddressRelation(modAddress);
    }

    @JsonIgnore
    @Override
    public boolean isUsageForAll() {
        return true;
    }

    @JsonIgnore
    @NotNull @Override
    public Optional<Set<AddressUsage>> getSpecificUsage() {
        return Optional.absent();
    }

    @Override
    public String toString() {
        return "UseForAllAddressRelation{" +
                "address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UseForAllAddressRelation that = (UseForAllAddressRelation) o;

        return address.equals(that.address);

    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }
}
