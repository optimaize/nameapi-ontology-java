package org.nameapi.ontology5.input.entities.person;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;
import org.nameapi.ontology5.util.ValueTransformerUtil;
import org.nameapi.ontology5.input.entities.address.AddressRelation;
import org.nameapi.ontology5.input.entities.contact.EmailAddress;
import org.nameapi.ontology5.input.entities.contact.TelNumber;
import org.nameapi.ontology5.input.entities.person.age.AgeInfo;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;

import java.util.List;

/**
 *
 * @author sam
 */
public class LegalInputPersonImpl extends AbstractInputPerson implements LegalInputPerson {

    @JsonCreator
    public LegalInputPersonImpl(
            @JsonProperty("personName") @NotNull Optional<InputPersonName> personName,
            @JsonProperty("age") @NotNull Optional<AgeInfo> age,
            @JsonProperty("correspondenceLanguage") @NotNull Optional<String> correspondenceLanguage,
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
        if (!personName.isPresent() && !age.isPresent() && !correspondenceLanguage.isPresent() && this.addresses.isEmpty() && this.telNumbers.isEmpty() && this.emailAddresses.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be available!");
        }
    }


    @Override
    public String toString() {
        String ret = "LegalInputPersonImpl{";
        if (personName.isPresent()) ret += "personName=" + personName;
        if (age.isPresent()) ret += ", age=" + age;
        if (correspondenceLanguage.isPresent()) ret += ", correspondenceLanguage='" + correspondenceLanguage + '\'';
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

        LegalInputPersonImpl that = (LegalInputPersonImpl) o;

        if (!addresses.equals(that.addresses)) return false;
        if (!age.equals(that.age)) return false;
        if (!correspondenceLanguage.equals(that.correspondenceLanguage)) return false;
        if (!emailAddresses.equals(that.emailAddresses)) return false;
        if (!personName.equals(that.personName)) return false;
        if (!telNumbers.equals(that.telNumbers)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personName.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + correspondenceLanguage.hashCode();
        result = 31 * result + addresses.hashCode();
        result = 31 * result + telNumbers.hashCode();
        result = 31 * result + emailAddresses.hashCode();
        return result;
    }

    @Nullable
    @Override
    public LegalInputPerson transform(@NotNull ValueTransformer transformer) {
        Optional<InputPersonName> modPersonName = getTransformedInputPersonName(transformer);
        Optional<AgeInfo> modAge = getTransformedAgeInfo(transformer);
        Optional<String> modCorrespondenceLanguage = ValueTransformerUtil.transformOptionalStringField(transformer, correspondenceLanguage);
        List<AddressRelation> modAddresses = getTransformedAddresses(transformer);
        List<TelNumber> modTelNumbers = getTransformedTelNumbers(transformer);
        List<EmailAddress> modEmailAddresses = getTransformedEmailAddresses(transformer);

        if (!modPersonName.isPresent() && !modAge.isPresent() && !modCorrespondenceLanguage.isPresent() && modAddresses.isEmpty() && modTelNumbers.isEmpty() && modEmailAddresses.isEmpty()) {
            return null;
        }
        return new LegalInputPersonImpl(modPersonName, modAge, modCorrespondenceLanguage, modAddresses, modTelNumbers, modEmailAddresses);
    }
}
