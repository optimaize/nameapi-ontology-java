package org.nameapi.ontology5.services.parser.personnameparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * A consistency problem detected by the parser is within this object.
 *
 * <p>These objects are not meant for machine processing. Logging for manual analysis is a good idea.</p>
 *
 * @author Nicole Torres
 */
public class ParserDispute {

    private final DisputeType disputeType;
    private final String message;

    @JsonCreator
    public ParserDispute(
            @JsonProperty("disputeType") @JsonPropertyDescription("The type of consistency problem detected by the name parser. See https://goo.gl/Y4yNhc for the documentation of the DisputeType enum values.") DisputeType disputeType,
            @JsonProperty("message") @JsonPropertyDescription("The explanation of the detected dispute.") String message
    ) {
        this.disputeType = disputeType;
        this.message = message;
    }

    public DisputeType getDisputeType() {
        return disputeType;
    }

    /**
     * @return the message that explains the problem that was detected.
     */
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ParserDispute{" +
                "disputeType=" + disputeType +
                ", message='" + message + '\'' +
                '}';
    }
}
