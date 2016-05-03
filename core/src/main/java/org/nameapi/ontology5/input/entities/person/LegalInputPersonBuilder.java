package org.nameapi.ontology5.input.entities.person;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;

/**
 * Builder to create {@link LegalInputPerson} instances.
 *
 * <p>Example use:
 * <pre><code>
 * LegalInputPerson person = new LegalInputPersonBuilder()
 *     .name( NameBuilders.legal().fullname("ACME Ltd.").build() )
 *     .addTelNumber( TelNumberFactory.forNumber("+33 3 86 30 77 88") )
 * .build();
 * </code></pre>
 * </p>
 *
 * @author sam
 */
public class LegalInputPersonBuilder extends InputPersonBuilder<LegalInputPersonBuilder> {

    public LegalInputPersonBuilder() {
    }

    /**
     * Initializes the builder with an existing person, allowing to modify values later.
     * This works like a copy constructor .
     * @param legalPerson For the initial values.
     */
    public LegalInputPersonBuilder(@NotNull LegalInputPerson legalPerson) {
        super(legalPerson);
    }



    @NotNull
    public LegalInputPerson build() {
        return new LegalInputPersonImpl(
                Optional.fromNullable(personName),
                Optional.fromNullable(ageInfo),
                Optional.fromNullable(correspondenceLanguage),
                addresses,
                telNumbers,
                emailAddresses
                );
    }

}
