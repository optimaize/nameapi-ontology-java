package org.nameapi.ontology5.input.context;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.google.common.base.Optional;
import org.nameapi.ontology5.cremalang.annotation.GeneratedCode;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.nameapi.ontology5.cremalang.lang.Arguments;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;
import org.nameapi.ontology5.Vocabulary;
import org.nameapi.ontology5.util.ValueTransformerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * The context defining the caller's environment for the execution.
 *
 * <p>Many web services use this object as a parameter.</p>
 *
 * <p>The context includes:
 * <ul>
 *     <li>cultural information such as the geographic region</li>
 *     <li>character sets and character ranges (script, case)</li>
 *     <li>custom properties sent to the server</li>
 * </ul>
 * </p>
 *
 * <p>Two of the custom properties currently supported are:
 * <ul>
 *      <li>"person.name-order" for the ratio of western vs. eastern writing system with a value like "western:55.436%,eastern:45.0%"</li>
 *      <li>"person.gender" for the ratio of male vs. female with a value like "male:70%,female:30%"</li>
 * </ul>
 * </p>
 *
 * <p>Use the {@link org.nameapi.ontology5.input.context.ContextBuilder} to create one.</p>
 *
 * @author sam
 */
@Immutable
public class Context {

    @NotNull
    private final Priority priority;
    @NotNull
    private final Optional<String> place;
    @NotNull
    private final Optional<String> language;
    @NotNull
    private final List<String> writingSystems;
    @NotNull
    private final Optional<TextCase> textCase;
    @NotNull
    private final ContextProperties properties;

    /**
     */
    @JsonCreator
    Context(@JsonProperty("priority") @JsonPropertyDescription("Tells whether someone (a human or a program) is waiting for the answer or not. See https://goo.gl/houakW for the documentation of the Priority enum values.") @Nullable Priority priority,
            @JsonProperty("place") @JsonPropertyDescription("The geographic area from where the request is coming.\n" +
                    "\n" +
                    "<p>This helps the server to better understand and classify the incoming data.\n" +
                    "Example: the given name \"Andrea\" is female in Germany but male in Italy.</p>\n" +
                    "\n" +
                    " <p><b>Value:</b> A geographic code such as an ISO-3166 two letter country code, for example \"FR\" for France.</p>\n" +
                    "\n" +
                    "<p>If the request is made in behalf of another company then the place may be adjusted to that.\n" +
                    "However, it is not meant to be set for the target customer.\n" +
                    "Example: Your company mainly operates in France (FR), and is the service provider for another\n" +
                    "company in Italy (IT), and the customer used in this web service request happens to be from\n" +
                    "Austria (AT), then the place should be set to \"IT\".</p>\n" +
                    "\n" +
                    "<p><b>Technical note:</b> when the system needs a Locale it uses the place with the language.</p>") @NotNull Optional<String> place,
            @JsonProperty("language") @JsonPropertyDescription("The language used for locale-sensitive operations such as converting a string to upper case.\n" +
                    "\n" +
                    "This is usually the primary language matching the {@link #place}, for example German for Germany.</p>\n" +
                    "\n" +
                    "<p>If not provided, and {@link #place} is available, the primary language for that place is used.</p>\n" +
                    "\n" +
                    "<p><b>Value:</b> A language code such as an ISO-639-1 two letter code, for example \"fr\" for French.</p>\n" +
                    "\n" +
                    "<p><b>Technical note:</b> when the system needs a Locale it uses the place with the language.</p>") @NotNull Optional<String> language,
            @JsonProperty("writingSystems") @JsonPropertyDescription("The writing system(s) used in the data source.\n" +
                    "<p>One code starts with the ISO 15924 script name, optionally followed by the ISO 639-1 or\n" +
                    "ISO 639-3 language code.</p>\n" +
                    "<p>Examples: \"Latn:de\", \"Latn:gsw\", \"Cyrl:ru\".</p>\n" +
                    "<p>Multiple writing systems may be used, for example \"Cyrl:sr\" plus \"Latn:sr\".</p>\n" +
                    "<p>The special non-standard script name \"Asci\" is used for the us-ascii character set.</p>\n" +
                    "\n" +
                    "<p>This hint helps the server to match terms with its databases, and generate better results.\n" +
                    "Also, the user may be warned when accidentally using characters not in his range, for example\n" +
                    "when a Cyrillic character slipped into his Latin customer database (which may be visually\n" +
                    " indistinguishable).</p>") @Nullable List<String> writingSystems,
            @JsonProperty("textCase") @JsonPropertyDescription("Tells in what case of writing (upper, lower ...) the data is sent to the server. See https://goo.gl/5gWeJX for the documentation of the TextCase enum values.") @NotNull Optional<TextCase> textCase,
            @JsonProperty("properties") @JsonPropertyDescription("<p>Arguments to send to the server.\n" +
                    "\n"+
                    "There are a few public properties. And custom properties may be created for customers to customize server behavior for their needs.</p>") @NotNull List<ContextProperty> properties
    ) {
        this.priority    = priority == null ? Priority.REALTIME : priority;
        this.place       = place;
        this.language    = language;
        this.writingSystems = Arguments.copyImmutable(writingSystems);
        this.textCase    = textCase;
        this.properties  = ContextProperties.forList(properties);
    }


    @NotNull
    public Priority getPriority() {
        return priority;
    }

    /**
     * @see Vocabulary#place
     */
    @NotNull
    public Optional<String> getPlace() {
        return place;
    }

    /**
     * @see Vocabulary#language
     */
    @NotNull
    public Optional<String> getLanguage() {
        return language;
    }

    /**
     * @see org.nameapi.ontology5.Vocabulary#writingSystem
     */
    @NotNull
    public List<String> getWritingSystems() {
        return writingSystems;
    }

    @NotNull
    public Optional<TextCase> getTextCase() {
        return textCase;
    }

    @JsonIgnore
    @NotNull
    public ContextProperties getContextProperties() {
        return properties;
    }

    /**
     * Use {@link #getContextProperties()}, this is here for JSON marshalling.
     */
    @NotNull
    public List<ContextProperty> getProperties() {
        return properties.getProperties();
    }


    /**
     * A new instance with all the same properties, except the TextCase is replaced.
     * Same instance if equal.
     */
    public Context withTextCase(TextCase textCase) {
        if (this.textCase.isPresent() && this.textCase.get().equals(textCase)) {
            return this;
        } else {
            return new Context(priority, place, language, writingSystems, Optional.of(textCase), properties.getProperties());
        }
    }


    @Nullable
    public Context transform(@NotNull ValueTransformer transformer) {
        Optional<String> modPlace = ValueTransformerUtil.transformOptionalStringField(transformer, place);
        Optional<String> modLanguage = ValueTransformerUtil.transformOptionalStringField(transformer, language);
        List<String> modWritingSystems = ValueTransformerUtil.transformStringList(transformer, writingSystems);

        List<ContextProperty> copyContextProperties = new ArrayList<>();
        ContextProperties modProperties = properties.transform(transformer);
        if (modProperties != null) {
            copyContextProperties.addAll(modProperties.getProperties());
        }

        if (!modPlace.isPresent() && !modLanguage.isPresent() && modWritingSystems.isEmpty() && !textCase.isPresent() && copyContextProperties.isEmpty()) {
            return null;
        }

        return new Context(priority, modPlace, modLanguage, modWritingSystems, textCase, copyContextProperties);
    }


    @Override
    public String toString() {
        String ret = "Context{";
        ret += "processMode='" + priority + '\'';
        if (place.isPresent()) ret += ", place='" + place.get() + '\'';
        if (language.isPresent()) ret += ", language='" + language.get() + '\'';
        if (textCase.isPresent()) ret += ", textCase=" + textCase.get();
        if (!properties.toMap().isEmpty()) ret += ", properties=" + properties;
        ret += '}';
        return ret;
    }


    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Context that = (Context) o;

        if (!priority.equals(that.priority)) return false;
        if (!place.equals(that.place)) return false;
        if (!language.equals(that.language)) return false;
        if (!properties.equals(that.properties)) return false;
        if (!textCase.equals(that.textCase)) return false;

        return true;
    }

    @Override @GeneratedCode
    public int hashCode() {
        int result = priority.hashCode();
        result = 31 * result + place.hashCode();
        result = 31 * result + language.hashCode();
        result = 31 * result + textCase.hashCode();
        result = 31 * result + properties.hashCode();
        return result;
    }

}
