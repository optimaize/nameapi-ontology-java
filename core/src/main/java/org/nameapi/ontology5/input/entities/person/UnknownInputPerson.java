package org.nameapi.ontology5.input.entities.person;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.input.entities.person.gender.StoragePersonGender;

import java.util.List;
import java.util.Set;

/**
 * Used when it's unknown what kind of person or group of person it is. It can be any of:
 *  - Single natural person
 *  - Multiple natural people, or a family.
 *  - Legal person
 *  - Garbage
 *
 * <p>Because it can be a natural person it contains all of the features of a natural person.
 * It does not contain the additional features of a legal person because if they were used,
 * it would be clear already that it is a legal person.</p>
 *
 * @author sam
 */
@Beta
public interface UnknownInputPerson extends InputPerson {

    @NotNull
    StoragePersonGender getGender();

    @NotNull
    MaritalStatus getMaritalStatus();


    /**
     * The person's (academic) titles.
     * <p>These are strings because it would not be possible to force the user to convert his title strings into
     * language-neutral enum values. There are way too many titles used in this world. So it will be up to
     * the analyzers to make something out of the list.</p>
     * <p>It's a list to keep the title order, and not a set because yes someone can be a double-doctor.</p>
     * <p>All titles may be squeezed into one string.</p>
     */
    @NotNull
    List<String> getTitles();


    /*
   TODO add "retired" status? "pensioner"? would shrink the possible age range in case the birthyear is missing.
   TODO add a field for 'highest education'? would shrink the possible age range in case the birthyear is missing.
    */


    /**
     * @return The nationalities eg [DE,FR] in upper case, or <code>null</code> if the info is not available.
     *         The method *should* not return an empty collection in case the nationality of a person is unknown.
     *         There are not too many people without any nationality, but it exists, and then that would be the
     *         correct case for an empty collection.
     */
    @NotNull
    List<String> getNationalities();

    /**
     * @return The mother tongue(s), or <code>null</code> in the information is not available.
     *         The method *should* not return an empty collection in case the mother tongue of a person is unknown.
     *         There are not too many people without any mother tongue, but it exists, and then that would be the
     *         correct case for an empty collection.
     */
    @NotNull
    List<String> getNativeLanguages();


    /**
     * @return A NameProfiler religion code such as "AB.CR" for Christianity.
     */
    @NotNull
    Optional<String> getReligion();

}
