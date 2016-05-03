package org.nameapi.ontology5.cremalang.lang;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Provides static utility methods for accepting arguments in methods and constructors.
 *
 * Similar to the Guava methods like ImmutableList.copyOf() but accepts null.
 */
public class Arguments {

    /**
     * Makes a copy and wraps it unmodifiable.
     * <p>Use this in an {@link org.nameapi.ontology5.cremalang.annotation.Immutable} object when accepting a param from the outside.</p>
     */
    @NotNull
    public static <T> List<T> copyImmutable(@Nullable List<T> in) {
        if (in==null || in.isEmpty()) {
            return Collections.emptyList();
        } else {
            return ImmutableList.copyOf(in);
        }
    }

    /**
     * Makes a copy and wraps it unmodifiable.
     * <p>Use this in an {@link org.nameapi.ontology5.cremalang.annotation.Immutable} object when accepting a param from the outside.</p>
     */
    @NotNull
    public static <T> Set<T> copyImmutable(@Nullable Set<T> in) {
        if (in==null || in.isEmpty()) {
            return Collections.emptySet();
        } else {
            return ImmutableSet.copyOf(in);
        }
    }

    /**
     * Makes a copy and wraps it unmodifiable.
     * <p>Use this in an {@link org.nameapi.ontology5.cremalang.annotation.Immutable} object when accepting a param from the outside.</p>
     */
    @NotNull
    public static <T1,T2> Map<T1,T2> copyImmutable(@Nullable Map<T1, T2> in) {
        if (in==null || in.isEmpty()) {
            return Collections.emptyMap();
        } else {
            return ImmutableMap.copyOf(in);
        }
    }

}
