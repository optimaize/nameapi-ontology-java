package org.nameapi.ontology5.input.entities.person;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.Vocabulary;
import org.nameapi.ontology5.input.entities.address.*;
import org.nameapi.ontology5.input.entities.contact.EmailAddress;
import org.nameapi.ontology5.input.entities.contact.TelNumber;
import org.nameapi.ontology5.input.entities.person.age.AgeInfo;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sam
 */
public abstract class InputPersonBuilder<T extends InputPersonBuilder> {

    @Nullable
    protected InputPersonName personName;

    @Nullable
    protected AgeInfo ageInfo;

    @Nullable
    protected String correspondenceLanguage;


    @Nullable
    protected List<AddressRelation> addresses;

    @Nullable
    protected List<TelNumber> telNumbers;
    @Nullable
    protected List<EmailAddress> emailAddresses;


    public InputPersonBuilder() {
    }

    /**
     * Initializes the builder with an existing Person, allowing to modify values later.
     * This works like a copy constructor .
     * @param inputPerson For the initial values.
     */
    public InputPersonBuilder(@NotNull InputPerson inputPerson) {
        personName = inputPerson.getPersonName().orNull();
        ageInfo = inputPerson.getAge().orNull();
        correspondenceLanguage = inputPerson.getCorrespondenceLanguage().orNull();
        addresses      = inputPerson.getAddresses();
        telNumbers     = inputPerson.getTelNumbers();
        emailAddresses = inputPerson.getEmailAddresses();
    }

    public T name(@Nullable InputPersonName inputPersonName) {
        this.personName = inputPersonName;
        return (T)this;
    }

    /**
     * @see Vocabulary#ageInfo
     */
    public T age(@Nullable AgeInfo ageInfo) {
        this.ageInfo = ageInfo;
        return (T)this;
    }

    /**
     * Sets it, just one is possible.
     * @param correspondenceLanguage for example "en" for English.
     */
    public T correspondenceLanguage(@Nullable String correspondenceLanguage) {
        org.nameapi.ontology5.cremalang.lang.Preconditions.notEmpty(correspondenceLanguage);
        this.correspondenceLanguage = correspondenceLanguage;
        return (T)this;
    }



    /**
     * @see Vocabulary#ageInfo
     */
    public T addAddressForAll(@NotNull InputAddress address) {
        if (addresses==null) addresses = new ArrayList<>();
        addresses.add( new UseForAllAddressRelation(address) );
        return (T)this;
    }
    /**
     * @see Vocabulary#ageInfo
     */
    public T addAddressFor(@NotNull InputAddress address, @NotNull AddressUsage... usage) {
        if (addresses==null) addresses = new ArrayList<>();
        addresses.add( new SpecificUsageAddressRelation(address, usage) );
        return (T)this;
    }

    /**
     * Adds it, multiple may be added.
     * @see Vocabulary#telNumbers
     */
    public T addTelNumber(@NotNull TelNumber telNumber) {
        if (telNumbers==null) telNumbers = new ArrayList<>();
        telNumbers.add(telNumber);
        return (T)this;
    }

    /**
     * @see Vocabulary#emailAddresses
     */
    public T addEmail(@NotNull EmailAddress emailaddress) {
        if (emailAddresses==null) emailAddresses = new ArrayList<>(4);
        emailAddresses.add(emailaddress);
        return (T)this;
    }


}
