package org.nameapi.ontology5.input.context;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    Context(@JsonProperty("priority") @Nullable Priority priority,
            @JsonProperty("place") @NotNull Optional<String> place,
            @JsonProperty("language") @NotNull Optional<String> language,
            @JsonProperty("writingSystems") @Nullable List<String> writingSystems,
            @JsonProperty("textCase") @NotNull Optional<TextCase> textCase,
            @JsonProperty("properties") @NotNull List<ContextProperty> properties
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
