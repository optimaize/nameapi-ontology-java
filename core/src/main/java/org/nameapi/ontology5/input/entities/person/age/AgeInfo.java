package org.nameapi.ontology5.input.entities.person.age;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.base.Optional;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

/**
 * Information about a {@link org.nameapi.ontology5.input.entities.person.InputPerson person}'s age.
 *
 * <p>For a NaturalPerson this is the birth-date/age info.
 * For a LegalPerson this is the founding date (activation date).</p>
 *
 * <p>For a legal person the meanings of terms are slightly different, yet not too far-fetched.</p>
 *
 * <p>The information may be a complete date such as 1980-12-31, or a year with month such as
 * 1980-12, or just a year such as 1980, or a year range such as 1980-1989.</p>
 *
 * @author sam
 */
@Immutable
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BirthDate.class, name = "BirthDate"),
        @JsonSubTypes.Type(value = BirthYear.class, name = "BirthYear"),
        @JsonSubTypes.Type(value = BirthYearMonth.class, name = "BirthYearMonth"),
        @JsonSubTypes.Type(value = BirthYearRange.class, name = "BirthYearRange"),
        @JsonSubTypes.Type(value = NullAgeInfo.class, name = "NullAgeInfo"),
})
public interface AgeInfo {

    /**
     * This may either be known as such, or be extracted out of a birth date.
     * @return 4 digits, for example 1986
     */
    @NotNull
    Optional<Integer> getYear();

    /**
     * @return 1-12
     */
    @NotNull
    Optional<Integer> getMonth();

    /**
     * @return 1-31
     */
    @NotNull
    Optional<Integer> getDay();


    /**
     * This may either be known as such, or be extracted out of another value such as a birth date.
     */
    @NotNull
    YearRange getYearRange();

    /**
     * Tells if the object contains no data at all.
     */
    boolean isEmpty();

    @Nullable
    AgeInfo transform(@NotNull ValueTransformer transformer);

}
