package org.nameapi.ontology5.input.entities.person;

import com.google.common.base.Optional;
import org.nameapi.ontology5.cremalang.lang.Arguments;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;
import org.nameapi.ontology5.input.entities.address.AddressRelation;
import org.nameapi.ontology5.input.entities.contact.EmailAddress;
import org.nameapi.ontology5.input.entities.contact.TelNumber;
import org.nameapi.ontology5.input.entities.person.age.AgeInfo;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sam
 */
public abstract class AbstractInputPerson implements InputPerson {


    @NotNull
    protected final Optional<InputPersonName> personName;

    @NotNull
    protected final Optional<AgeInfo> age;

    @NotNull
    protected final Optional<String> correspondenceLanguage;

    @NotNull
    protected final List<AddressRelation> addresses;
    @NotNull
    protected final List<TelNumber> telNumbers;
    @NotNull
    protected final List<EmailAddress> emailAddresses;


    public AbstractInputPerson(
            @NotNull Optional<InputPersonName> personName,
            @NotNull Optional<AgeInfo> age,
            @NotNull Optional<String> correspondenceLanguage,
            @Nullable List<AddressRelation> addresses,
            @Nullable List<TelNumber> telNumbers,
            @Nullable List<EmailAddress> emailAddresses
    ) {
        this.personName = personName;
        this.age = age;
        this.correspondenceLanguage = correspondenceLanguage;
        this.addresses  = Arguments.copyImmutable(addresses);
        this.telNumbers = Arguments.copyImmutable(telNumbers);
        this.emailAddresses = Arguments.copyImmutable(emailAddresses);
    }



    @NotNull @Override
    public Optional<InputPersonName> getPersonName() {
        return personName;
    }


    @NotNull @Override
    public Optional<AgeInfo> getAge() {
        return age;
    }


    @NotNull @Override
    public List<AddressRelation> getAddresses() {
        return addresses;
    }

    @NotNull @Override
    public List<TelNumber> getTelNumbers() {
        return telNumbers;
    }

    @NotNull @Override
    public List<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }


    @NotNull @Override
    public Optional<String> getCorrespondenceLanguage() {
        return correspondenceLanguage;
    }

    @NotNull
    protected Optional<InputPersonName> getTransformedInputPersonName(ValueTransformer transformer) {
        Optional<InputPersonName> modPersonName = Optional.absent();
        if (personName.isPresent()) {
            modPersonName = Optional.fromNullable(personName.get().transform(transformer));
        }
        return modPersonName;
    }

    @NotNull
    protected Optional<AgeInfo> getTransformedAgeInfo(ValueTransformer transformer) {
        Optional<AgeInfo> modAge = Optional.absent();
        if (age.isPresent()) {
            modAge = Optional.fromNullable(age.get().transform(transformer));
        }
        return modAge;
    }

    @NotNull
    protected List<AddressRelation> getTransformedAddresses(ValueTransformer transformer) {
        List<AddressRelation> modAddresses = new ArrayList<>(addresses.size());
        for (AddressRelation addressRelation : addresses) {
            AddressRelation modified = addressRelation.transform(transformer);
            if (modified!=null) {
                modAddresses.add(modified);
            }
        }
        return modAddresses;
    }

    @NotNull
    protected List<TelNumber> getTransformedTelNumbers(ValueTransformer transformer) {
        List<TelNumber> modTelNumbers = new ArrayList<>(telNumbers.size());
        for (TelNumber telNumber : telNumbers) {
            TelNumber modified = telNumber.transform(transformer);
            if (modified!=null) {
                modTelNumbers.add(modified);
            }
        }
        return modTelNumbers;
    }

    @NotNull
    protected List<EmailAddress> getTransformedEmailAddresses(ValueTransformer transformer) {
        List<EmailAddress> modEmailAddresses = new ArrayList<>(emailAddresses.size());
        for (EmailAddress emailAddress : emailAddresses) {
            EmailAddress modified = emailAddress.transform(transformer);
            if (modified!=null) {
                modEmailAddresses.add(modified);
            }
        }
        return modEmailAddresses;
    }
}
