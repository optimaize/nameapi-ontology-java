package org.nameapi.ontology5.input.entities.address;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

import java.util.List;

/**
 * Information about the locality, possibly including:
 *  - locality
 *  - postal code
 *  - neighborhood
 *  - region (state)
 *  - country
 *
 * @author sam
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StructuredPlaceInfo.class, name = "SegregatedPlaceInfo"),
})
public interface PlaceInfo {

    /**
     * @return the whole place information in a single string.
     */
    @NotNull
    String getAsString();

    /**
     * Returns the whole place information as text lines, containing at least 1 line.
     * If there are two lines then it is common that the first line contains the {@link #getPostalCode()}
     * and the {@link #getLocality()} and other things especially the {@link #getCountry()} come on another line.
     */
    @NotNull
    List<String> getAsLines();

    /**
     * Returns the locality and postal code, in any order.
     *
     * <p>Whether the postal code or the locality comes first depends on stuff. How it's entered, how it's
     * common for the country, etc.</p>
     *
     * <p>When the data is available separate in {@link #getLocality} and {@link #getPostalCode}
     * then this method here returns a combination of those. The implementation is advised to concatenate
     * the values in a format which is suitable for the customs. For example a specialized GermanAddress
     * would append the locality after the postal code, separated by a space.</p>
     *
     * @return <code>absent</code> if no locality and postal code are known at all.
     *         <code>absent</code> if this info is not available alone.
     */
    @NotNull
    Optional<String> getLocalityAndPostalCode();

//    /**
//     * Returns the information from the fields for building, staircase, floor and apartment.
//     * @return <code>absent</code> if no such information is available, or it is not available alone.
//     */
//    @NotNull
//    Optional<String> getAddressLine2();




    /**
     * @see AddressItemType#LOCALITY
     * @return The locality,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @NotNull
    Optional<String> getLocality();

    /**
     * <p>The postal code should not be prefixed with a country code that is not part of the postal code itself,
     * such as an ISO 3166-1 alpha-2 code. Example: "FR-71320" or "F-71320". If possible then the country code
     * should be dropped. The ISO 31-66-1 alpha-2 maybe directly used as the {@link #getCountry country} instead.</p>
     *
     * @see AddressItemType#POSTALCODE
     * @return The postal code alone,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @NotNull
    Optional<String> getPostalCode();

    /**
     * @see AddressItemType#NEIGHBORHOOD
     * @return The neighborhood,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @NotNull
    Optional<String> getNeighborhood();

    /**
     * @see AddressItemType#REGION
     * @return The building identifier,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @NotNull
    Optional<String> getRegion();

    /**
     * @see AddressItemType#COUNTRY
     * @return The country,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @NotNull
    Optional<String> getCountry();


    @Nullable
    PlaceInfo transform(@NotNull ValueTransformer transformer);
}
