package org.nameapi.ontology5.input.entities.address;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

import java.util.Set;

/**
 * Specifies for what purposes a certain {@link InputAddress} is, for example for {@link AddressUsage#CORRESPONDENCE}.
 *
 * @author sam
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = UseForAllAddressRelation.class, name = "UseForAllAddressRelation"),
        @JsonSubTypes.Type(value = SpecificUsageAddressRelation.class, name = "SpecificUsageAddressRelation"),
})
public interface AddressRelation {

    /**
     * If the address is used for all purposes then {@link #getSpecificUsage} returns <code>null</code>.
     */
    boolean isUsageForAll();

    /**
     * Returns 1-n usages for that address unless {@link #isUsageForAll} returns <code>true</code>.
     * @return 1-n entries when isUsageForAll()=false, otherwise <code>null</code>.
     */
    @NotNull
    Optional<Set<AddressUsage>> getSpecificUsage();

    /**
     * Returns the address for that relation.
     */
    @NotNull
    InputAddress getAddress();

    @Nullable
    AddressRelation transform(@NotNull ValueTransformer transformer);

}
