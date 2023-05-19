package org.nameapi.ontology5.services.riskdetector;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Close attention to the @JsonTypeInfo annotation!
 * <p>
 * It tells Jackson that no type information is to be included in serialization.
 * <p>
 * We erase the type information, and we won't be able to deserialize it back to the original type.
 * Especially because we use the same value name: {@link FakeRiskType#OTHER} and {@link DisguiseRiskType#OTHER}.
 * <p>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FakeRiskType.class, name = "FakeRiskType"),
        @JsonSubTypes.Type(value = DisguiseRiskType.class, name = "DisguiseRiskType")}
)
public interface RiskType {

}
