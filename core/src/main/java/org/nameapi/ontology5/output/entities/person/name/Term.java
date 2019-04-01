package org.nameapi.ontology5.output.entities.person.name;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.jetbrains.annotations.NotNull;

/**
 * Used in the {@link org.nameapi.ontology5.services.parser.personnameparser.ParsedPerson}.
 *
 * @author Nicole Torres
 */
public class Term {

    @NotNull
    private final String string;
    @NotNull
    private final TermType termType;

    @JsonCreator
    public Term(
            @JsonProperty("string") @JsonPropertyDescription("The string of the term.") @NotNull String string,
            @JsonProperty("termType") @JsonPropertyDescription("The type of the term. See https://goo.gl/FtesDX for the documentation of the TermType enum values.") @NotNull TermType termType
    ) {
        this.string = string;
        this.termType = termType;
    }

    /**
     * @param moreSpecificThing not used
     */
    @Deprecated
    public Term(@NotNull String string, @NotNull TermType termType, Object moreSpecificThing) {
        this.string = string;
        this.termType = termType;
//        this.moreSpecificThing = moreSpecificThing;
    }

    @NotNull
    public String getString() {
        return string;
    }

    @NotNull
    public TermType getTermType() {
        return termType;
    }


    @Override
    public String toString() {
        return "Term{" +
                "string='" + string + '\'' +
                ", type=" + termType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Term field = (Term) o;

        if (termType != field.termType) return false;
        if (!string.equals(field.string)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = string.hashCode();
        result = 31 * result + termType.hashCode();
        return result;
    }

}
