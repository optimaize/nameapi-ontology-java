package org.nameapi.ontology5.input.context;

import com.google.common.base.Optional;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.Vocabulary;

import java.util.*;

/**
 * Builder for the {@link Context}.
 *
 * @author sam
 */
@Immutable
public class ContextBuilder {

    private Priority priority;
    private String place;
    private String language;
    private List<String> writingSystems;
    private TextCase textCase;
    private Map<String,String> properties;

    public ContextBuilder() {
    }


    private static final Context EMPTY = new Context(null, Optional.<String>absent(), Optional.<String>absent(), Collections.<String>emptyList(), Optional.<TextCase>absent(), ContextProperties.empty().getProperties());
    public static Context empty() {
        return EMPTY;
    }


    @NotNull
    public ContextBuilder priority(@NotNull Priority priority) {
        this.priority = priority;
        return this;
    }

    /**
     * @param place For example "FR" for France.
     * @see Vocabulary#place
     */
    @NotNull
    public ContextBuilder place(@Nullable String place) {
        if (place != null && place.isEmpty()) {
            throw new IllegalArgumentException("Place: empty string not permitted, use null!");
        }
        this.place = place;
        return this;
    }

    /**
     * @param language For example "fr" for French.
     * @see Vocabulary#language
     */
    @NotNull
    public ContextBuilder language(@Nullable String language) {
        if (language != null && language.isEmpty()) {
            throw new IllegalArgumentException("Language: empty string not permitted, use null!");
        }
        this.language = language;
        return this;
    }

    /**
     * Adds it, multiple additions are possible.
     * Silently ignores the call if it was added before already.
     * @see org.nameapi.ontology5.Vocabulary#writingSystem
     */
    @NotNull
    public ContextBuilder writingSystem(@NotNull String writingSystem) {
        if (this.writingSystems==null) this.writingSystems = new ArrayList<>(4);
        if (!this.writingSystems.contains(writingSystem)) {
            this.writingSystems.add(writingSystem);
        }
        return this;
    }

    @NotNull
    public ContextBuilder textCase(@NotNull TextCase textCase) {
        this.textCase = textCase;
        return this;
    }

    /**
     * Calls {@link #property} for each item in {@code properties}.
     */
    @NotNull
    public ContextBuilder properties(@NotNull Map<String, String> properties) {
        for (Map.Entry<String, String> stringStringEntry : properties.entrySet()) {
            property(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        return this;
    }
    /**
     * If a property with that key exists already, it's silently overwritten.
     *
     * <p>No trimming is performed in here.</p>
     *
     * @see Vocabulary#contextProperties
     */
    @NotNull
    public ContextBuilder property(@NotNull String key, @NotNull String value) {
        if (properties==null) {
            properties = new HashMap<>();
        }
        properties.put(key, value);
        return this;
    }


    /**
     */
    @NotNull
    public Context build() throws IllegalStateException {
        return new Context(
                priority,
                Optional.fromNullable(place),
                Optional.fromNullable(language),
                writingSystems,
                Optional.fromNullable(textCase),
                ContextProperties.forMap(properties).getProperties()
        );
    }


    @Override
    public String toString() {
        String ret = "ContextBuilder{";
        if (priority != null) ret += "processMode='" + priority + '\'';
        if (place != null) ret += "place='" + place + '\'';
        if (language != null) ret += "language='" + language + '\'';
        if (writingSystems!=null) ret += ", writingSystems=" + writingSystems;
        if (textCase!=null) ret += ", textCase=" + textCase;
        if (properties!=null && !properties.isEmpty()) ret += ", properties=" + properties;
        ret += '}';
        return ret;
    }

}
