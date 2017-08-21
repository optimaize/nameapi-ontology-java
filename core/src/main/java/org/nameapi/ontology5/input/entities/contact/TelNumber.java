package org.nameapi.ontology5.input.entities.contact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

/**
 * The basic interface for a contact number such as a phone or fax number, mobile or fixnet.
 *
 * <p>The name "Tel" was chosen because VCard http://en.wikipedia.org/wiki/VCard uses it too.</p>
 *
 *
 * TODO
 * see http://www.ietf.org/rfc/rfc6350.txt
 +-----------+-------------------------------------------------------+
 | Value     | Description                                           |
 +-----------+-------------------------------------------------------+
 | text      | Indicates that the telephone number supports text     |
 |           | messages (SMS).                                       |
 | voice     | Indicates a voice telephone number.                   |
 | fax       | Indicates a facsimile telephone number.               |
 | cell      | Indicates a cellular or mobile telephone number.      |
 | video     | Indicates a video conferencing telephone number.      |
 | pager     | Indicates a paging device telephone number.           |
 | textphone | Indicates a telecommunication device for people with  |
 |           | hearing or speech difficulties.                       |
 +-----------+-------------------------------------------------------+
 *
 *
 * @author Nicole Torres
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleTelNumber.class, name = "SimpleTelNumber")
})
public interface TelNumber {

    /**
     * Returns the complete number in any format.
     *
     * <p>This is the minimal required api for all implementations.</p>
     *
     * <p>Implementations may provide additional getters for information such as:
     * <ul>
     *   <li>type of number (phone, fax, mobile, fixed, ...)</li>
     *   <li>separate country code, area code and number</li>
     * </ul></p>
     *
     * @return Not empty. The term "number" may be stretched here. It may contain spaces and punctuation, and
     *         also letters as substitutes for numbers.
     */
    @NotNull
    String getFullNumber();

    @Nullable
    TelNumber transform(@NotNull ValueTransformer transformer);

}
