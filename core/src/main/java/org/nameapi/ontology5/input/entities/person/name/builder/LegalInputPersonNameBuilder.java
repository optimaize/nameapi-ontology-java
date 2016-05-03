package org.nameapi.ontology5.input.entities.person.name.builder;

import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.input.entities.person.name.NameField;
import org.nameapi.ontology5.input.entities.person.name.types.LegalNameFieldType;

/**
 * Builder for creating a person name to be used in a {@link org.nameapi.ontology5.input.entities.person.LegalInputPerson}.
 *
 * <p>Examples:
 * <pre>
 *   new LegalInputPersonNameBuilder().name("Google").legalForm("Incorporated").build();
 *   new LegalInputPersonNameBuilder().name("Google Inc.").build();
 * </pre></p>
 *
 * @author aa
 */
public class LegalInputPersonNameBuilder extends InputPersonNameBuilder {

    /**
     * For the legal person this does the same as {@link #name}.
     */
    @NotNull
    public LegalInputPersonNameBuilder fullname(@NotNull String s) {
        return add(s, LegalNameFieldType.LEGAL_NAME);
    }
    @NotNull
    public LegalInputPersonNameBuilder name(@NotNull String s) {
        return add(s, LegalNameFieldType.LEGAL_NAME);
    }

    @NotNull
    public LegalInputPersonNameBuilder legalForm(@NotNull String s) {
        return add(s, LegalNameFieldType.LEGAL_FORM);
    }


    private LegalInputPersonNameBuilder add(String s, LegalNameFieldType fieldType) {
        super.nameField(new NameField(s, fieldType));
        return this;
    }

}
