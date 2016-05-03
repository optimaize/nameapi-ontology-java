package org.nameapi.ontology5.input.entities.person;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;

/**
 * See http://en.wikipedia.org/wiki/Legal_personality
 *
 * @author sam
 */
@Beta
public interface LegalInputPerson extends InputPerson {

    //for now this has no extra fields.

    //this is in the name, possibly. can be a separate name field.
//    @NotNull
//    Optional<Object> getLegalForm();


    //TODO add fields for tax number and company registration number.
    //they look different and have different meaning depending on country. but that's fine. simple strings should do.


}
