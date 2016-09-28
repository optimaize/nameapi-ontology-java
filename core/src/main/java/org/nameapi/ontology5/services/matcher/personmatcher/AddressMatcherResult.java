package org.nameapi.ontology5.services.matcher.personmatcher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
public class AddressMatcherResult {

    private final AddressMatchType addressMatchType;
    private final PlaceMatchType placeMatchType;
    private final StreetMatchType streetMatchType;
    private final PostboxMatchType postboxMatchType;

    @JsonCreator
    public AddressMatcherResult(
            @JsonProperty("addressMatchType") AddressMatchType addressMatchType,
            @JsonProperty("placeMatchType") PlaceMatchType placeMatchType,
            @JsonProperty("streetMatchType") StreetMatchType streetMatchType,
            @JsonProperty("postboxMatchType") PostboxMatchType postboxMatchType
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
