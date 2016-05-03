package org.nameapi.ontology5.input.entities.person;

import com.google.common.base.Optional;
import org.nameapi.ontology5.cremalang.lang.Arguments;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.Preconditions;
import org.nameapi.ontology5.input.entities.person.gender.StoragePersonGender;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder to create {@link NaturalInputPerson} instances.
 *
 * <p>Example use:
 * <pre><code>
 * NaturalInputPerson person = new NaturalInputPersonBuilder()
 *     .name( NameBuilders.western().givenName("John").surname("Doe").build() )
 *     .gender( StoragePersonGender.MALE )
 * .build();
 * </code></pre>
 * </p>
 *
 * @author sam
 */
public class NaturalInputPersonBuilder extends InputPersonBuilder<NaturalInputPersonBuilder> {

    @NotNull
    private StoragePersonGender gender = StoragePersonGender.UNKNOWN;
    @NotNull
    private MaritalStatus maritalStatus = MaritalStatus.UNKNOWN;

    @Nullable
    private List<String> nationalities;
    @Nullable
    private List<String> nativeLanguages;
    @Nullable
    private String religion;


    public NaturalInputPersonBuilder() {
    }

    /**
     * Initializes the builder with an existing person, allowing to modify values later.
     * This works like a copy constructor .
     * @param naturalPerson For the initial values.
     */
    public NaturalInputPersonBuilder(@NotNull NaturalInputPerson naturalPerson) {
        super(naturalPerson);
        gender = naturalPerson.getGender();
        maritalStatus = naturalPerson.getMaritalStatus();
        nationalities = Arguments.copyImmutable(naturalPerson.getNationalities());
        nativeLanguages = Arguments.copyImmutable(naturalPerson.getNativeLanguages());
        religion       = naturalPerson.getReligion().orNull();
    }



    public NaturalInputPersonBuilder gender(@NotNull StoragePersonGender gender) {
        this.gender = gender;
        return this;
    }
    public NaturalInputPersonBuilder maritalStatus(@NotNull MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }



    /**
     * Adds it, multiple can be added.
     * @param iso3166 for example "FR" for France.
     */
    public NaturalInputPersonBuilder addNationality(@NotNull String iso3166) {
        Preconditions.checkIso3166(iso3166);
        if (nationalities==null) nationalities = new ArrayList<>();
        nationalities.add(iso3166);
        return this;
    }
    /**
     * Adds it, multiple can be added.
     * @param nativeLanguage for example "fr" for French.
     */
    public NaturalInputPersonBuilder addNativeLanguage(@NotNull String nativeLanguage) {
        org.nameapi.ontology5.cremalang.lang.Preconditions.notEmpty(nativeLanguage);
        if (nativeLanguages == null) nativeLanguages = new ArrayList<>();
        nativeLanguages.add(nativeLanguage);
        return this;
    }

    /**
     *
     * @param religion A NameAPI religion code such as "AB.CR" for Christianity.
     */
    public void religion(@Nullable String religion) {
        org.nameapi.ontology5.cremalang.lang.Preconditions.notEmpty(religion);
        this.religion = religion;
    }


    @NotNull
    public NaturalInputPerson build() {
        return new NaturalInputPersonImpl(
                Optional.fromNullable(personName),
                gender,
                Optional.fromNullable(ageInfo),
                maritalStatus,
                nationalities,
                nativeLanguages,
                Optional.fromNullable(correspondenceLanguage),
                Optional.fromNullable(religion),
                addresses,
                telNumbers,
                emailAddresses
        );
    }

}
