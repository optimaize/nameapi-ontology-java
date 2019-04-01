package org.nameapi.ontology5.input.entities.address;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

import java.util.List;

/**
 * Information about the house, possibly including:
 *  - street name
 *  - street number
 *  - block, entrance, floor
 *  - apartment/suite
 *
 * @author sam
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StructuredStreetInfo.class, name = "StructuredStreetInfo"),
        @JsonSubTypes.Type(value = SingleStringStreetInfo.class, name = "SingleStringStreetInfo")
})
public interface StreetInfo {

    /**
     * @return the whole street information in a single string.
     */
    @JsonPropertyDescription("The whole street information in a single string.")
    @NotNull
    String getAsString();

    /**
     * Returns the whole street information as text lines, containing at least 1 line.
     * If there are two lines then it is common that the first line contains the {@link #getStreetNameAndNumber}
     * while the second contains the {@link #getAddressLine2}.
     */
    @JsonPropertyDescription("Returns the whole street information as text lines, containing at least 1 line.")
    @NotNull
    List<String> getAsLines();

    /**
     * Returns the street name possibly with a number.
     *
     * <p>This getter may have information even when {@link #getStreetName} doesn't. That's the case when
     * the data source only has the street available unparsed with the number - which is often the case.
     * In that case it's also possible that the data is only available "together", but some records don't
     * have a street number at all in the string. It's up to the calling method to do the parsing.</p>
     *
     * <p>When the data is available separate in {@link #getStreetName} and {@link #getHouseNumber}
     * then this method here returns a combination of those. The implementation is advised to concatenate
     * the values in a format which is suitable for the customs. For example a specialized GermanAddress
     * would append the number to the street, separated by a space.</p>
     *
     * @return <code>absent</code> if no street name and number are known at all, for example because it's a
     *         postbox address.
     *         <code>absent</code> if this info is not available alone.
     */
    @JsonPropertyDescription("Returns the street name possibly with a number.")
    @NotNull
    Optional<String> getStreetNameAndNumber();

    /**
     * Returns the information from the fields for building, staircase, floor and apartment.
     * @return <code>absent</code> if no such information is available, or it is not available alone.
     */
    @JsonPropertyDescription("Returns the information from the fields for building, staircase, floor and apartment.")
    @NotNull
    Optional<String> getAddressLine2();



    /**
     * @return The street name alone,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @JsonPropertyDescription("The street name alone, or absent if this info is not available or not available alone.")
    @NotNull
    Optional<String> getStreetName();

    /**
     * <p>Something like "15" or "15-17" or "15b" etc.</p>
     * <p>There are addresses without a house identifier. An example is when there is just that one house,
     * for example a farm house, on that road.</p>
     * @return The house number/identifier alone,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @JsonPropertyDescription("Something like \"15\" or \"15-17\" or \"15b\" etc. The house number/identifier alone, " +
            "or absent if this info is not available or not available alone.")
    @NotNull
    Optional<String> getHouseNumber();

    /**
     * @see AddressItemType#BUILDING
     * @return The building identifier,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @JsonPropertyDescription("The building identifier, or absent if this info is not available or not available alone.")
    @NotNull
    Optional<String> getBuilding();

    /**
     * @see AddressItemType#STAIRCASE
     * @return The staircase identifier,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @JsonPropertyDescription("The staircase identifier, or absent if this info is not available or not available alone.")
    @NotNull
    Optional<String> getStaircase();

    /**
     * @see AddressItemType#FLOOR
     * @return The floor number,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @JsonPropertyDescription("The floor number, or absent if this info is not available or not available alone.")
    @NotNull
    Optional<String> getFloor();

    /**
     * @see AddressItemType#APARTMENT
     * @return The apartment/suite,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @JsonPropertyDescription(" The apartment/suite, or absent if this info is not available or not available alone.")
    @NotNull
    Optional<String> getApartment();


    @Nullable
    StreetInfo transform(@NotNull ValueTransformer transformer);
}
