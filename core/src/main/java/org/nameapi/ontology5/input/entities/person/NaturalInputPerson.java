package org.nameapi.ontology5.input.entities.person;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.input.entities.person.gender.StoragePersonGender;

import java.util.List;

/**
 * See http://en.wikipedia.org/wiki/Natural_person
 *
 * @author sam
 * @see NaturalInputPersonBuilder
 */
public interface NaturalInputPerson extends InputPerson {

    @NotNull
    StoragePersonGender getGender();

    @NotNull
    MaritalStatus getMaritalStatus();



    /*
   TODO add "retired" status? "pensioner"? would shrink the possible age range in case the birthyear is missing.
   TODO add a field for 'highest education'? would shrink the possible age range in case the birthyear is missing.

   TODO add field for place-of-birth (birthplace) see https://tools.ietf.org/html/rfc6474
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
