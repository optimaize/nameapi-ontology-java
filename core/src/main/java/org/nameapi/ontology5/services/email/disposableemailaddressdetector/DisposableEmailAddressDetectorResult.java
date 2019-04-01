package org.nameapi.ontology5.services.email.disposableemailaddressdetector;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.nameapi.ontology5.cremalang.lang.Maybe;
import org.jetbrains.annotations.NotNull;

/**
 * @author Nicole Torres
 */
public class DisposableEmailAddressDetectorResult {

    @NotNull
    private final Maybe disposable;

    @JsonCreator
    public DisposableEmailAddressDetectorResult(
            @JsonProperty("disposable") @JsonPropertyDescription("The result of the disposable email address detector. See https://goo.gl/EHZ4VT for the documentation of the Maybe enum values.") @NotNull Maybe disposable
    ) {
        this.disposable = disposable;
    }

    @NotNull
    public Maybe getDisposable() {
        return disposable;
    }

    @Override
    public String toString() {
        return "DisposableEmailAddressDetectorResult{" +
                "disposable=" + disposable +
                '}';
    }
}
