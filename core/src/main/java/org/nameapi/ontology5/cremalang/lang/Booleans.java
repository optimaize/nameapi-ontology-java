package org.nameapi.ontology5.cremalang.lang;

import org.jetbrains.annotations.NotNull;

/**
 * Provides utility methods for dealing with boolean values.
 *
 * @author ga
 */
public class Booleans {

    /**
     * Safe method for parsing a boolean value from a String.
     *
     * @param b a boolean value
     * @return <code>true</code> if b equals ignoring case one of the values: true, yes, on, 1 and <code>false</code> for the values: false, no, off, 0.
     * @throws IllegalArgumentException on non-understood values in contrast to Boolean.valueOf() which you should never ever use.
     */
    public static boolean fromString(@NotNull String b) {
        /*
         * do not, i repeat, do not change this specification.
         */

        if (b.equalsIgnoreCase("true")) return true;
        if (b.equalsIgnoreCase("yes")) return true;
        if (b.equalsIgnoreCase("on")) return true;
        if (b.equalsIgnoreCase("1")) return true;

        if (b.equalsIgnoreCase("false")) return false;
        if (b.equalsIgnoreCase("no")) return false;
        if (b.equalsIgnoreCase("off")) return false;
        if (b.equalsIgnoreCase("0")) return false;

        throw new IllegalArgumentException("Unsupported boolean value, be specific: >>>" + b + "<<<");
    }

}
