package org.nameapi.ontology5.input.entities.person;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.nameapi.ontology5.cremalang.lang.Arguments;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.NameTransformer;
import org.nameapi.ontology5.util.ValueTransformer;
import org.nameapi.ontology5.util.ValueTransformerUtil;
import org.nameapi.ontology5.input.entities.address.AddressRelation;
import org.nameapi.ontology5.input.entities.contact.EmailAddress;
import org.nameapi.ontology5.input.entities.contact.TelNumber;
import org.nameapi.ontology5.input.entities.person.age.AgeInfo;
import org.nameapi.ontology5.input.entities.person.gender.StoragePersonGender;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;

import java.util.Collections;
import java.util.List;

/**
 * Default implementation of {@link NaturalInputPerson}.
 * 
 * @author sam
 * @see NaturalInputPersonBuilder
 */
@Immutable
final class NaturalInputPersonImpl extends AbstractInputPerson implements NaturalInputPerson {

//    private static final NaturalInputPersonImpl EMPTY = new NaturalInputPersonImpl(
//            Optional.<InputPersonName>absent(), //inputPersonName
//            StoragePersonGender.UNKNOWN,
//            Optional.<AgeInfo>absent(), // ageInfo
//            MaritalStatus.UNKNOWN,
//            null, // nationalities
//            null, // nativeLanguages
//            Optional.<String>absent(), // correspondenceLanguage
//            Optional.<String>absent(), // religion
//            null, // addresses
//            null, // telNumbers
//            null // emailAddresses
//    );
//
//    /**
//     * Returns an empty person, that is, one that has no values set.
//     */
//    public static NaturalInputPersonImpl empty() {
//        return EMPTY;
//    }


    @NotNull
    private final StoragePersonGender gender;
    @NotNull
    private final MaritalStatus maritalStatus;

    @NotNull
    private final List<String> nationalities;
    @NotNull
    private final List<String> nativeLanguages;
    @NotNull
    private final Optional<String> religion;



    @JsonCreator
    public NaturalInputPersonImpl(
            @JsonProperty("personName") @NotNull Optional<InputPersonName> personName,
            @JsonProperty("gender") @Nullable StoragePersonGender gender,
            @JsonProperty("age") @NotNull Optional<AgeInfo> age,
            @JsonProperty("maritalStatus") @Nullable MaritalStatus maritalStatus,
            @JsonProperty("nationalities") @Nullable List<String> nationalities,
            @JsonProperty("nativeLanguages") @Nullable List<String> nativeLanguages,
            @JsonProperty("correspondenceLanguage") @NotNull Optional<String> correspondenceLanguage,
            @JsonProperty("religion") @NotNull Optional<String> religion,
            @JsonProperty("addresses") @Nullable List<AddressRelation> addresses,
            @JsonProperty("telNumbers") @Nullable List<TelNumber> telNumbers,
            @JsonProperty("emailAddresses") @Nullable List<EmailAddress> emailAddresses
    ) {
        super(personName,
                age,
                correspondenceLanguage,
                addresses,
                telNumbers,
                emailAddresses
                );

        this.gender = gender!=null ? gender : StoragePersonGender.UNKNOWN;
        this.maritalStatus   = maritalStatus!=null ? maritalStatus : MaritalStatus.UNKNOWN;
        this.nationalities   = Arguments.copyImmutable(nationalities);
        this.nativeLanguages = Arguments.copyImmutable(nativeLanguages);
        this.religion   = religion;

        if (!personName.isPresent() && gender.isUnknown() && !age.isPresent() && maritalStatus.isUnknown() && this.nationalities.isEmpty()
                && this.nativeLanguages.isEmpty() && !correspondenceLanguage.isPresent() && !religion.isPresent() && this.addresses.isEmpty()
                && this.telNumbers.isEmpty() && this.emailAddresses.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be available!");
        }
    }



    @NotNull @Override
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    @Override @NotNull
    public StoragePersonGender getGender() {
        return gender;
    }



    @NotNull
    public List<String> getNationalities() {
        return Collections.unmodifiableList(nationalities);
    }

    @NotNull
    public List<String> getNativeLanguages() {
        return Collections.unmodifiableList(nativeLanguages);
    }


    @NotNull @Override
    public Optional<String> getReligion() {
        return religion;
    }


    @Override
    public String toString() {
        String ret = "NaturalInputPersonImpl{";
        if (personName.isPresent()) ret += "personName=" + personName;
        if (!gender.isUnknown()) ret += ", gender=" + gender;
        if (age.isPresent()) ret += ", age=" + age;
        if (!maritalStatus.isUnknown()) ret += ", maritalStatus=" + maritalStatus;
        if (!nationalities.isEmpty()) ret += ", nationalities=" + nationalities;
        if (!nativeLanguages.isEmpty()) ret += ", nativeLanguages=" + nativeLanguages;
        if (correspondenceLanguage.isPresent()) ret += ", correspondenceLanguage='" + correspondenceLanguage + '\'';
        if (religion.isPresent()) ret += ", religion='" + religion + '\'';
        if (!addresses.isEmpty()) ret += ", addresses=" + addresses;
        if (!telNumbers.isEmpty()) ret += ", telNumbers=" + telNumbers;
        if (!emailAddresses.isEmpty()) ret += ", emailAddresses=" + emailAddresses;
        ret += '}';
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NaturalInputPersonImpl that = (NaturalInputPersonImpl) o;

        if (!addresses.equals(that.addresses)) return false;
        if (!age.equals(that.age)) return false;
        if (!correspondenceLanguage.equals(that.correspondenceLanguage)) return false;
        if (!emailAddresses.equals(that.emailAddresses)) return false;
        if (gender != that.gender) return false;
        if (maritalStatus != that.maritalStatus) return false;
        if (!nationalities.equals(that.nationalities)) return false;
        if (!nativeLanguages.equals(that.nativeLanguages)) return false;
        if (!personName.equals(that.personName)) return false;
        if (!religion.equals(that.religion)) return false;
        if (!telNumbers.equals(that.telNumbers)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personName.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + maritalStatus.hashCode();
        result = 31 * result + nationalities.hashCode();
        result = 31 * result + nativeLanguages.hashCode();
        result = 31 * result + correspondenceLanguage.hashCode();
        result = 31 * result + religion.hashCode();
        result = 31 * result + addresses.hashCode();
        result = 31 * result + telNumbers.hashCode();
        result = 31 * result + emailAddresses.hashCode();
        return result;
    }

    @Nullable
    @Override
    public NaturalInputPerson transform(@NotNull ValueTransformer transformer) {
        Optional<InputPersonName> modPersonName = getTransformedInputPersonName(transformer);
        Optional<AgeInfo> modAge = getTransformedAgeInfo(transformer);

        List<String> modNationalities = ValueTransformerUtil.transformStringList(transformer, nationalities);
        List<String> modNativeLanguages = ValueTransformerUtil.transformStringList(transformer, nativeLanguages);

        Optional<String> modCorrespondenceLanguage = ValueTransformerUtil.transformOptionalStringField(transformer, correspondenceLanguage);
        Optional<String> modReligion = ValueTransformerUtil.transformOptionalStringField(transformer, religion);

        List<AddressRelation> modAddresses = getTransformedAddresses(transformer);
        List<TelNumber> modTelNumbers = getTransformedTelNumbers(transformer);
        List<EmailAddress> modEmailAddresses = getTransformedEmailAddresses(transformer);

        if (!modPersonName.isPresent() && gender.isUnknown() && !modAge.isPresent() && maritalStatus.isUnknown() &&
                modNationalities.isEmpty() && modNativeLanguages.isEmpty() &&
                !modCorrespondenceLanguage.isPresent() && !modReligion.isPresent() &&
                modAddresses.isEmpty() && modTelNumbers.isEmpty() && modEmailAddresses.isEmpty()) {
            return null;
        }

        return new NaturalInputPersonImpl(modPersonName, gender, modAge, maritalStatus, modNationalities, modNativeLanguages,
                modCorrespondenceLanguage, modReligion, modAddresses, modTelNumbers, modEmailAddresses);
    }

    @Nullable
    @Override
    public InputPerson transform(@NotNull NameTransformer transformer) {
        if (!personName.isPresent()) {
            return this;
        }
        InputPersonName modPersonName = transformer.transform(personName.get());
        if (modPersonName==null && gender.isUnknown() && !age.isPresent() && maritalStatus.isUnknown() &&
                nationalities.isEmpty() && nativeLanguages.isEmpty() &&
                !correspondenceLanguage.isPresent() && !religion.isPresent() &&
                addresses.isEmpty() && telNumbers.isEmpty() && emailAddresses.isEmpty()) {
            return null;
        }
        return new NaturalInputPersonImpl(Optional.fromNullable(modPersonName), gender, age, maritalStatus, nationalities, nativeLanguages,
                correspondenceLanguage, religion, addresses, telNumbers, emailAddresses);
    }

}
