package org.nameapi.ontology5.input.entities.person.name;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

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

    @JsonPropertyDescription("<p>The values are organized by culture. The name types that are often used in the USA\n" +
            "are in the AmericanNameFieldType}, and so on. Certain values appear in multiple but their meaning is the same.\n \n</p>" +
            "<p>Name field types:" +
            "<ul>" +
            "<li>AmericanNameFieldType - Contains the name field types that are often used in America. See https://goo.gl/WP85x8</li>" +
            "<li>ArabicNameFieldType -  The *traditional* name fields of the Arabic culture. See https://goo.gl/cgH7gw</li>" +
            "<li>CommonNameFieldType - Contains the name field types that are commonly shared by many cultures. See https://goo.gl/eKR6Em</li>" +
            "<li>LegalNameFieldType - Contains the field types that are used by organizations. See https://goo.gl/uY2zwQ</li>" +
            "<li>OtherNameFieldType - A place for \"other\" types that don't fit into Common and are not too culture specific. See https://goo.gl/Gt7cZg</li>" +
            "<li>WesternNameFieldType - Currently no values here, they all fit into CommonNameFieldType.</li>" +
            "</ul>" +
            "</p>")
    Enum getEnum();

}
