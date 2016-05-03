package org.nameapi.ontology5.input.entities.person.name;

/**
 * Common interface for the enum values.
 *
 * <p>The values are organized by culture. The name types that are often used in the USA
 * are in the {@link org.nameapi.ontology5.input.entities.person.name.types.AmericanNameFieldType}, and so on. Certain values appear in multiple;
 * their meaning is the same.</p>
 *
 * @author sam
 */
public interface FieldType {

    /**
     * The enum values provide this already.
     */
    String name();

    Enum getEnum();

}
