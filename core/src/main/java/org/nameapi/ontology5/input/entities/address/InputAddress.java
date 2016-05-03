package org.nameapi.ontology5.input.entities.address;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

import java.util.List;

/**
 * Represents a physical address which can be an address to a house or to a postbox.
 *
 * @see StructuredAddressBuilder
 * @author sam
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SingleStringAddress.class, name = "SingleStringAddress"),
        @JsonSubTypes.Type(value = MultiLineAddress.class, name = "MultiLineAddress"),
        @JsonSubTypes.Type(value = StructuredAddress.class, name = "StandardAddress"),
})
public interface InputAddress {

    /**
     * Returns the address information line by line.
     * This is the only getter that all implementations must support.
     * @return Not empty.
     *         The implementations should use a data format that suits their data.
     *         For example a specific implementation for a Canadian address should,
     *         if possible, return the data in Canadian formatting style.
     */
    @NotNull
    List<String> getAddressLines();

//    /**
//     * Tells if all address information within this class is only accessible through
//     * {@link #getAddressLines}. If so then the specialized getters such as {@link #getPostalCode}
//     * all return null.
//     */
//    boolean isPlaintextAddress();


    /**
     * Information about the street name, street number, apartment/suite.
     * @return <code>missing</code> If no street/house information is known at all, For example because it's a
     *         {@link #getPobox postbox} address, or if it's a raw address.
     */
    @NotNull
    Optional<StreetInfo> getStreetInfo();

    /**
     * Usually the post box number as it appears in the address.
     *
     * <p>If the string is non-null then it's not empty, and contains either a number, or a string
     * like "postbox", or both like "Po box 2435" etc.</p>
     *
     * @return <code>missing</code> if it's not a postbox address, or if it's a raw address.
     */
    @NotNull
    Optional<String> getPobox();

    /**
     * Information about the locality.
     * @return <code>missing</code> if it's a raw address.
     */
    @NotNull
    Optional<PlaceInfo> getPlaceInfo();


    @Nullable
    InputAddress transform(@NotNull ValueTransformer transformer);

}
