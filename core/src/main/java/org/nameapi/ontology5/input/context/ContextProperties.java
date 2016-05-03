package org.nameapi.ontology5.input.context;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.nameapi.ontology5.cremalang.annotation.GeneratedCode;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.nameapi.ontology5.cremalang.lang.Booleans;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

import java.util.*;

/**
 * Container for {@link ContextProperty}s.
 *
 * <p>Provides convenience methods for working with them.</p>
 *
 * <p>This class does not perform any normalization or cleaning on the values.
 * No trimming, no case standardization. It is up to the user.</p>
 *
 * @author Gabriela Achim
 */
@Immutable
public class ContextProperties {

    private static ContextProperties EMPTY = new ContextProperties(Collections.<String, String>emptyMap());

    public static ContextProperties forMap(@Nullable Map<String, String> properties) {
        if (properties==null || properties.isEmpty()) {
            return EMPTY;
        } else {
            return new ContextProperties(properties);
        }
    }
    public static ContextProperties forList(@Nullable List<ContextProperty> properties) {
        if (properties==null || properties.isEmpty()) {
            return EMPTY;
        } else {
            return new ContextProperties(properties);
        }
    }
    public static ContextProperties empty() {
        return EMPTY;
    }



    /**
     * The Map structure is here for fast loopups.
     */
    @JsonIgnore
    @NotNull
    private final Map<String, String> map;

    /**
     * The List structure is here for JSON marshalling.
     */
    @NotNull
    private final List<ContextProperty> properties;


    private ContextProperties(@NotNull Map<String, String> map) {
        if (map.isEmpty()) {
            this.map = Collections.emptyMap();
            this.properties = Collections.emptyList();
        } else {
            this.map = ImmutableMap.copyOf(map);

            List<ContextProperty> properties = new ArrayList<>(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                properties.add(new ContextProperty(entry.getKey(), entry.getValue()));
            }
            this.properties = properties;
        }
    }

    private ContextProperties(@Nullable List<ContextProperty> properties) {
        if (properties==null || properties.isEmpty()) {
            this.map = Collections.emptyMap();
            this.properties = Collections.emptyList();
        } else {
            this.properties = ImmutableList.copyOf(properties);

            Map<String, String> map = new HashMap<>();
            for (ContextProperty property : properties) {
                if (map.containsKey(property.getName())) {
                    throw new IllegalArgumentException("Duplicate property name: >>>"+property.getName()+"<<<!");
                }
                map.put(property.getName(), property.getValue());
            }
            this.map = map;
        }
    }


    /**
     * @return True if there is not a single property in here.
     */
    @JsonIgnore
    public boolean isEmpty() {
        return map.isEmpty();
    }


    public boolean hasProperty(@NotNull String name) {
        return map.containsKey(name);
    }

    /**
     * @see org.nameapi.ontology5.Vocabulary#contextProperties
     * @param name The key of the property
     * @return <code>absent</code> if there is no such property.
     *         If present then the value is not <code>null</code>.
     */
    @NotNull
    public Optional<String> getString(@NotNull String name) {
        String value = map.get(name);
        return Optional.fromNullable(value);
    }

    /**
     * @return the boolean value of the property <code>name</code> or <code>absent</code> if there is no such property.
     * @throws RuntimeException when the property does not have a valid boolean value assigned.
     */
    @NotNull
    public Optional<Boolean> getBoolean(@NotNull String name) {
        if (!hasProperty(name)) return Optional.absent();
        String value = map.get(name);
        try {
            return Optional.of(Booleans.fromString(value));
        } catch (Exception e) {
            throw new RuntimeException("The property " + name + " is not a valid boolean: >>>" + value + "<<<!", e);
        }
    }

    /**
     * @return false when there is no such property or the property is not a valid boolean value.
     */
    public boolean isBoolean(@NotNull String name) {
        if (!hasProperty(name)) return false;
        String value = map.get(name);
        try {
            return Booleans.fromString(value);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @return the integer value of the property <code>name</code> or <code>absent</code> if there is no such property.
     * @throws RuntimeException when the property does not have a valid Integer value assigned.
     */
    @NotNull
    public Optional<Integer> getInteger(@NotNull String name) {
        if (!hasProperty(name)) return Optional.absent();
        String value = map.get(name);
        try {
            return Optional.of(Integer.parseInt(value, 10));
        } catch (Exception e) {
            throw new RuntimeException("The property " + name + " is not a valid Integer: >>>" + value + "<<<!", e);
        }
    }

    /**
     * @return false when there is no such property or the property is not a valid Integer value.
     */
    public boolean isInteger(@NotNull String name) {
        if (!hasProperty(name)) return false;
        String value = map.get(name);
        try {
            //noinspection ResultOfMethodCallIgnored
            Integer.parseInt(value, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @return the double value of the property <code>name</code> or <code>absent</code> if there is no such property.
     * @throws RuntimeException when the property does not have a valid double value assigned.
     */
    @NotNull
    public Optional<Double> getDouble(@NotNull String name) {
        if (!hasProperty(name)) return Optional.absent();
        String value = map.get(name);
        try {
            return Optional.of(Double.parseDouble(value));
        } catch (Exception e) {
            throw new RuntimeException("The property " + name + " is not a valid double: >>>" + value + "<<<!", e);
        }
    }

    /**
     * @return false when there is no such property or the property is not a valid double value.
     */
    public boolean isDouble(@NotNull String name) {
        if (!hasProperty(name)) return false;
        String value = map.get(name);
        try {
            //noinspection ResultOfMethodCallIgnored
            Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * It should not contain null keys or null values.
     * @return Unmodifiable. May be empty.
     */
    @NotNull
    public Map<String, String> toMap() {
        return map;
    }


    /**
     * You probably don't need this. The JSON marshaller likes to see it.
     */
    @NotNull
    public List<ContextProperty> getProperties() {
        return properties;
    }

    @Nullable
    public ContextProperties transform(@NotNull ValueTransformer transformer) {
        List<ContextProperty> copy = new ArrayList<>(properties.size());
        for (ContextProperty property : properties) {
            ContextProperty modified = property.transform(transformer);
            if (modified != null) {
                copy.add(modified);
            }
        }
        if (copy.isEmpty()) return null;
        return ContextProperties.forList(copy);
    }


    @Override
    public String toString() {
        return map.toString();
    }

    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContextProperties that = (ContextProperties) o;
        return map.equals(that.map);

    }
    @Override @GeneratedCode
    public int hashCode() {
        return map.hashCode();
    }

}
