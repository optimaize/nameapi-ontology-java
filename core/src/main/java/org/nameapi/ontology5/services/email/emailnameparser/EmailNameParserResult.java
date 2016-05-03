package org.nameapi.ontology5.services.email.emailnameparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * @author Nicole Torres
 */
@Immutable
public class EmailNameParserResult {

    @NotNull
    private final EmailAddressParsingResultType resultType;
    @NotNull
    private final List<EmailNameParserMatch> nameMatches;

    @JsonCreator
    public EmailNameParserResult(
            @JsonProperty("resultType") @NotNull EmailAddressParsingResultType resultType,
            @JsonProperty("nameMatches") @NotNull List<EmailNameParserMatch> nameMatches
    ) {
        this.resultType = resultType;
        this.nameMatches = Collections.unmodifiableList(nameMatches);
    }


    @NotNull
    public EmailAddressParsingResultType getResultType() {
        return resultType;
    }

    @JsonIgnore
    @NotNull
    public Optional<EmailNameParserMatch> getBestNameMatch() {
        if (nameMatches.isEmpty()) return Optional.absent();
        return Optional.of(nameMatches.get(0));
    }

    /**
     * The first entry (if any) is the best, they are ordered by likeliness in descending order.
     */
    @NotNull
    public List<EmailNameParserMatch> getNameMatches() {
        return nameMatches;
    }

    @Override @NotNull
    public String toString() {
        return getResultType() + ": "+ nameMatches;
    }

}
