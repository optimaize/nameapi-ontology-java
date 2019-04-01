package org.nameapi.ontology5.services.matcher.personmatcher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 */
public class AddressMatcherResult {

    private final AddressMatchType addressMatchType;
    private final PlaceMatchType placeMatchType;
    private final StreetMatchType streetMatchType;
    private final PostboxMatchType postboxMatchType;

    @JsonCreator
    public AddressMatcherResult(
            @JsonProperty(value = "addressMatchType", required = true) @JsonPropertyDescription("Tells how two physical addresses match.\nSee https://goo.gl/EsbNNa for the documentation of the AddressMatchType enum values.") AddressMatchType addressMatchType,
            @JsonProperty("placeMatchType") @JsonPropertyDescription("Tells how a place (including the name and postal code matches).\nSee https://goo.gl/TDD1rf for the documentation of the PlaceMatchType enum values.") PlaceMatchType placeMatchType,
            @JsonProperty("streetMatchType") @JsonPropertyDescription("Tells how a street (including street name and house number matches).\nSee https://goo.gl/vLzzRX for the documentation of the StreetMatchType enum values.") StreetMatchType streetMatchType,
            @JsonProperty("postboxMatchType") @JsonPropertyDescription("Tells how two postboxes match.\nSee https://goo.gl/dmxSF7 for the documentation of the PostboxMatchType enum values.") PostboxMatchType postboxMatchType
    ) {
        this.addressMatchType = addressMatchType;
        this.placeMatchType = placeMatchType;
        this.streetMatchType = streetMatchType;
        this.postboxMatchType = postboxMatchType;
    }

    public AddressMatchType getAddressMatchType() {
        return addressMatchType;
    }

    public PlaceMatchType getPlaceMatchType() {
        return placeMatchType;
    }

    public StreetMatchType getStreetMatchType() {
        return streetMatchType;
    }

    public PostboxMatchType getPostboxMatchType() {
        return postboxMatchType;
    }

    @Override
    public String toString() {
        return "AddressMatcherResult{" +
                "addressMatchType=" + addressMatchType +
                ", placeMatchType=" + placeMatchType +
                ", streetMatchType=" + streetMatchType +
                ", postboxMatchType=" + postboxMatchType +
                '}';
    }

}
