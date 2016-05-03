package org.nameapi.ontology5.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Provides typical static precondition methods that throw {@link IllegalArgumentException} on
 * any problem.
 *
 * @author sam
 */
public class Preconditions {

    /**
     * Checks if the given string is a valid ISO-3166 country code (2-letter in upper case).
     */
    public static boolean isIso3166(@NotNull String possiblyIso3166) {
        return possiblyIso3166.length()==2 && possiblyIso3166.matches("^[A-Z]{2}$");
    }

    /**
     * Makes sure the given string is a valid ISO-3166 country code (2-letter in upper case).
     * @throws IllegalArgumentException
     */
    public static void checkIso3166(@Nullable String codeIso3166) {
        if (codeIso3166!=null && !isIso3166(codeIso3166)) {
            throw new IllegalArgumentException("Not a valid ISO-3166 code: '"+ codeIso3166 +"'!");
        }
    }

}
