package org.nameapi.ontology5.input.entities.person;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
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

    @JsonPropertyDescription("Defines a person's names such as given name(s) and surname(s).\n" +
            "\n"+
            "Multiple given names may appear in one field. Or they can be added as multiple name items if " +
            "they are available separately already. The same applies for other name types such as surnames.")
    @NotNull
    Optional<InputPersonName> getPersonName();

    /**
     * @see Vocabulary#ageInfo
     */
    @JsonPropertyDescription("Information about a person's age.\n" +
            "\n" +
            "For a NaturalPerson this is the birth-date/age info. For a LegalPerson this is the founding\n" +
            "date (activation date).</p>\n" +
            "\n" +
            "<p><b>Usage:</b>\n" +
            "Depends on the service.\n" +
            "A validator service may check for valid dates, and report problems (such as 1986-02-31).\n" +
            "A genderizer service may use it to filter irrelevant birth statistics.\n" +
            "</p>\n" +
            "<p><b>Invalid input:</b>\n" +
            "The behavior on illegal input depends on the web service that is called. Invalid (xml) input\n" +
            "such as a non-numeric string should always result in an illegal input exception. An invalid date\n" +
            "such as 1986-02-31 may trigger an illegal input exception, or it may just be ignored.\n")
    @NotNull
    Optional<AgeInfo> getAge();


    /**
     * @see Vocabulary#addresses
     */
    @JsonPropertyDescription("Addresses that are used by this person.\n" +
            "\n" +
            "<p>Multiple addresses may be passed (domicile, mailing/delivery address, ...) or a single address may be\n" +
            "responsible for all purposes. </p>\n" +
            "\n" +
            "<p><b>Usage:</b>\n" +
            "Depends on the service.\n" +
            "A validator service may check for valid addresses, and report problems (such as invalid zip codes).\n" +
            "A genderizer service may use it to better classify the names.\n" +
            "</p>\n" +
            "\n" +
            "<p><b>Invalid input:</b>\n" +
            "The behavior on illegal input depends on the web service that is called.\n" +
            "A validator service may report problems with an address. Other services mostly just ignore\n" +
            "invalid address data as it is not their task to validate, and the information is just helping\n" +
            "to better understand the input and is not essential.\n" +
            "</p>")
    @NotNull
    List<AddressRelation> getAddresses();


    /**
     * @see Vocabulary#telNumbers
     */
    @JsonPropertyDescription("Phone, fax etc numbers that are used by this person.\n" +
            "\n" +
            "<p>Multiple numbers may be added.</p>\n" +
            "\n" +
            "<p><b>Usage:</b>\n" +
            "Depends on the service.\n" +
            "A data validator service may check for problems.\n" +
            "A fake checker may look for suspicious input.\n" +
            "</p>\n" +
            "\n" +
            "<p><b>Invalid input:</b>\n" +
            "The behavior on illegal input depends on the web service that is called.\n" +
            "A validator service may report problems with an address. Other services mostly just ignore\n" +
            "invalid phone data as it is not their task to validate, and the information is just helping\n" +
            "to better understand the input and is not essential.\n" +
            "</p>")
    @NotNull
    List<TelNumber> getTelNumbers();

    /**
     * @see Vocabulary#emailAddresses
     */
    @JsonPropertyDescription("Email addresses that are used by this person.\n" +
            "\n" +
            "<p>Multiple addresses may be added.</p>\n" +
            "\n" +
            "<p><b>Usage:</b>\n" +
            "Depends on the service.\n" +
            "A data validator service may check for problems such as illegal syntax or inexistent domain.\n" +
            "A service may check for disposable email addresses.\n" +
            "It may be used to extract name information.\n" +
            "A validator service may compare the name in the email address with the person's name.\n" +
            "</p>\n" +
            "\n" +
            "<p><b>Invalid input:</b>\n" +
            "The behavior on illegal input depends on the web service that is called.\n" +
            "A validator service may report problems with invalid email address syntax, or inexistent domain\n" +
            "names, etc.\n" +
            "Services may throw an invalid input exception.\n" +
            "</p>")
    @NotNull
    List<EmailAddress> getEmailAddresses();


    /**
     * @see Vocabulary#correspondenceLanguage
     */
    @JsonPropertyDescription("The language code for the correspondence language of the person (with you, the company).\n" +
            "\n" +
            "<p>ISO-639 code of the language. Either 639-1 or 639-3, for example \"it\" or \"ita\" for Italian.</p>\n" +
            "\n" +
            "<p><b>Usage:</b>\n" +
            "In combination with the Context.place it helps the services to better classify the culture of the person.\n" +
            "</p>\n" +
            "\n" +
            "<p><b>Invalid input:</b>\n" +
            "The behavior on illegal input depends on the web service that is called.\n" +
            "It may ignore it, or throw an invalid input exception.\n" +
            "</p>")
    @NotNull
    Optional<String> getCorrespondenceLanguage();


    @Nullable
    InputPerson transform(@NotNull ValueTransformer transformer);

    @Nullable
    InputPerson transform(@NotNull NameTransformer transformer);
}
