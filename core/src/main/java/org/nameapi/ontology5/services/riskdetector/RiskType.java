package org.nameapi.ontology5.services.riskdetector;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FakeRiskType.class, name = "FakeRiskType"),
        @JsonSubTypes.Type(value = DisguiseRiskType.class, name = "DisguiseRiskType") }
)
public interface RiskType {

}
