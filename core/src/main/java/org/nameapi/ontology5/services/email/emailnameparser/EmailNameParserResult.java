package org.nameapi.ontology5.services.email.emailnameparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.cremalang.annotation.Immutable;

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
            @JsonProperty("resultType") @JsonPropertyDescription("Tells what was detected in the local-part (user name) of the email address.") @NotNull EmailAddressParsingResultType resultType,
            @JsonProperty("nameMatches") @JsonPropertyDescription("A list of successful ways of parsing a name out of an email address.") @NotNull List<EmailNameParserMatch> nameMatches
    ) {
        this.resultType = resultType;
        this.nameMatches = Collections.unmodifiableList(nameMatches);
    }


    @NotNull
    public EmailAddressParsingResultType getResultType() {
        return resultType;
    }

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
