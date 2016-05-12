package org.nameapi.ontology5.input.entities.person;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.NameTransformer;
import org.nameapi.ontology5.util.ValueTransformer;
import org.nameapi.ontology5.Vocabulary;
import org.nameapi.ontology5.input.entities.address.AddressRelation;
import org.nameapi.ontology5.input.entities.contact.EmailAddress;
import org.nameapi.ontology5.input.entities.contact.TelNumber;
import org.nameapi.ontology5.input.entities.person.age.AgeInfo;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;

import java.util.List;

/**
 * A {@link NaturalInputPerson natural} or {@link LegalInputPerson legal}
 * person as used in crm databases, online user databases etc.
 *
 * <p>This is the snapshot of a person's personal data. Some attributes like name and marital status
 * can change in time.</p>
 * 
 * @author sam
 * @see NaturalInputPersonBuilder
 */
@SuppressWarnings({"JavaDoc"})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NaturalInputPersonImpl.class, name = "NaturalInputPerson"),
        @JsonSubTypes.Type(value = LegalInputPersonImpl.class, name = "LegalInputPerson"),
})
public interface InputPerson {

    @NotNull
    Optional<InputPersonName> getPersonName();

    /**
     * @see Vocabulary#ageInfo
     */
    @NotNull
    Optional<AgeInfo> getAge();


    /**
     * @see Vocabulary#addresses
     */
    @NotNull
    List<AddressRelation> getAddresses();


    /**
     * @see Vocabulary#telNumbers
     */
    @NotNull
    List<TelNumber> getTelNumbers();

    /**
     * @see Vocabulary#emailAddresses
     */
    @NotNull
    List<EmailAddress> getEmailAddresses();


    /**
     * @see Vocabulary#correspondenceLanguage
     */
    @NotNull
    Optional<String> getCorrespondenceLanguage();


    @Nullable
    InputPerson transform(@NotNull ValueTransformer transformer);

    @Nullable
    InputPerson transform(@NotNull NameTransformer transformer);
}
