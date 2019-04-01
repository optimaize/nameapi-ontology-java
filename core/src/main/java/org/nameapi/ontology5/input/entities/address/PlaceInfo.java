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
        @JsonSubTypes.Type(value = StructuredPlaceInfo.class, name = "StructuredPlaceInfo"),
})
public interface PlaceInfo {

    /**
     * @return the whole place information in a single string.
     */
    @JsonPropertyDescription("The whole place information in a single string.")
    @NotNull
    String getAsString();

    /**
     * Returns the whole place information as text lines, containing at least 1 line.
     * If there are two lines then it is common that the first line contains the {@link #getPostalCode()}
     * and the {@link #getLocality()} and other things especially the {@link #getCountry()} come on another line.
     */
    @JsonPropertyDescription("Returns the whole place information as text lines, containing at least 1 line.\n" +
            "If there are two lines then it is common that the first line contains the #getPostalCode\n" +
            "and the #getLocality and other things especially the #getCountry() come on another line.")
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
    @JsonPropertyDescription("<p>Returns the locality and postal code, in any order.</p>\n" +
            "\n" +
            "<p>Whether the postal code or the locality comes first depends on stuff. How it's entered, how it's\n" +
            "common for the country, etc.</p>\n" +
            "\n" +
            "<p>When the data is available separate in #getLocality and #getPostalCode\n" +
            "then this method here returns a combination of those. The implementation is advised to concatenate\n" +
            "the values in a format which is suitable for the customs. For example a specialized GermanAddress\n" +
            "would append the locality after the postal code, separated by a space.</p>")
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
    @JsonPropertyDescription("The city/town/village/municipality/place name.")
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
    @JsonPropertyDescription("<p>The postal code should not be prefixed with a country code that is not part of the postal code itself,\n" +
            "such as an ISO 3166-1 alpha-2 code. Example: \"FR-71320\" or \"F-71320\". If possible then the country code\n" +
            "should be dropped. The ISO 31-66-1 alpha-2 maybe directly used as the {@link #getCountry country} instead.</p>" +
            "\n"+
            "Examples:\n" +
            "<ul>" +
            "   <li>\"94107\" USA\n</li>" +
            "   <li>\"H3Z 2Y7\" Canada\n</li>" +
            "   <li>\"8022\" Switzerland\n</li>" +
            "   <li>\"CH-8022\" Switzerland, european style of adding country code as prefix</li>" +
            "</ul>")
    @NotNull
    Optional<String> getPostalCode();

    /**
     * @see AddressItemType#NEIGHBORHOOD
     * @return The neighborhood,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @JsonPropertyDescription("<p>The city area/neighborhood/district/sector information.</p>\n" +
            "Examples:\n" +
            "<ul>" +
            "   <li>\"Vila Industrial\" in Brazil\n</li>" +
            "   <li>\"Sector 6\" in Romania, only used in the capital Bucharest</li>" +
            "</ul>")
    @NotNull
    Optional<String> getNeighborhood();

    /**
     * @see AddressItemType#REGION
     * @return The building identifier,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @JsonPropertyDescription("<p>The region or region code (state, county, province), such as \"CA\" in the USA for California.</p>\n" +
            "Examples:\n" +
            "<ul>" +
            "   <li>\"CA\" for California USA\n</li>" +
            "   <li>\"Jud. Brasov\" in Romania</li>" +
            "</ul>")
    @NotNull
    Optional<String> getRegion();

    /**
     * @see AddressItemType#COUNTRY
     * @return The country,
     *         or <code>absent</code> if this info is not available or not available alone.
     */
    @JsonPropertyDescription("<p>The country code or name in any language.</p>\n" +
            "Examples:\n" +
            "<ul>" +
            "   <li>\"DE\" Germany (ISO 3166-alpha2 code)\n</li>" +
            "   <li>\"Germany\"\n</li>" +
            "   <li>\"U.S.A.\"</li>" +
            "</ul>")
    @NotNull
    Optional<String> getCountry();


    @Nullable
    PlaceInfo transform(@NotNull ValueTransformer transformer);
}
