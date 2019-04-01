package org.nameapi.ontology5.services.formatter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.NotNull;

/**
 * @author Fabian Kessler
 */
public class FormatterResult {

    @NotNull
    private final String formatted;

    private final boolean unknown;


    @JsonCreator
    public FormatterResult(
            @JsonProperty("formatted") @JsonPropertyDescription("The nicely formatted string, possibly the same as the input.") @NotNull String formatted,
            @JsonProperty("unknown") @JsonPropertyDescription("If true then server didn't understand the input, but still tried to format it.\n" +
                    "This feature must be enabled specifically in the input properties.") boolean unknown
    ) {
        this.formatted = formatted;
        this.unknown   = unknown;
    }


    /**
     * @return the nicely formatted string, possibly the same as the input.
     */
    @NotNull
    public String getFormatted() {
        return formatted;
    }

    /**
     * @return if <code>true</code> then server didn't understand the input, but still tried to format it.
     * This feature must be enabled specifically in the input properties.
     */
    public boolean isUnknown() {
        return unknown;
    }


    @Override
    public String toString() {
        return "CaseFormatterResult{" +
                "formatted='" + formatted + '\'' +
                ", unknown=" + unknown +
                '}';
    }

}
