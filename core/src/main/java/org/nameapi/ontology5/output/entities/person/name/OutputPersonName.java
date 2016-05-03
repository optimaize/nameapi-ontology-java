package org.nameapi.ontology5.output.entities.person.name;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import org.nameapi.ontology5.cremalang.annotation.GeneratedCode;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * All the names identified in an input person name.
 *
 * @author Nicole Torres
 */
public class OutputPersonName {

    @NotNull
    private final List<Term> terms;


    @JsonCreator
    public OutputPersonName(
            @JsonProperty("terms") @NotNull List<Term> terms
    ) {
        this.terms = ImmutableList.copyOf(terms);
    }


    /**
     * @return Not empty, all values are non-null and trimmed and not empty.
     */
    @NotNull
    public List<Term> getTerms() {
        return terms;
    }

    @NotNull
    public Optional<Term> getFirst(@NotNull TermType termType) {
        for (Term term : terms) {
            if (term.getTermType()==termType) return Optional.of(term);
        }
        return Optional.absent();
    }

    @NotNull
    public Optional<Term> getSecond(@NotNull TermType termType) {
        boolean had = false;
        for (Term term : terms) {
            if (term.getTermType()==termType) {
                if (had) {
                    return Optional.of(term);
                } else {
                    had = true;
                }
            }
        }
        return Optional.absent();
    }

    /**
     * @return Not null, may be empty.
     */
    @NotNull
    public List<Term> getAll(final TermType termType) {
        return ImmutableList.copyOf(Collections2.filter(terms, new Predicate<Term>() {
            @Override
            public boolean apply(Term input) {
                return input.getTermType() == termType;
            }
        }));
    }


    @Override @GeneratedCode
    public String toString() {
        return "OutputPersonName{" +
                "terms=" + terms +
                '}';
    }

    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutputPersonName that = (OutputPersonName) o;

        if (!terms.equals(that.terms)) return false;

        return true;
    }

    @Override @GeneratedCode
    public int hashCode() {
        return terms.hashCode();
    }

}
