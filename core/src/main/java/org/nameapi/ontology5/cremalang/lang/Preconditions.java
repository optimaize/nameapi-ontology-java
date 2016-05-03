package org.nameapi.ontology5.cremalang.lang;

import org.nameapi.ontology5.cremalang.annotation.NullInNullOut;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * COPY-PASTED ON 2014-08-28 FROM CREMA-LANG
 *
 *
 *
 *
 *
 *
 *
 * Typical preconditions like the ones offered by Guava.
 */
public class Preconditions {

    private Preconditions() {
        throw new Error("No instance!");
    }

    @NotNull
    public static <T> T notNull(T o) throws IllegalArgumentException {
        return notNull(o, null);
    }
    @NotNull
    public static <T> T notNull(T o, @Nullable String varName) throws IllegalArgumentException {
        if (o == null) {
            String msg = "Variable ";
            if (varName!=null) msg += varName;
            msg += " was null!";
            throw new IllegalArgumentException(msg);
        }
        return o;
    }

    /**
     * Checks that the string is either null, or not empty.
     */
    @NullInNullOut
    public static String notEmpty(String s) throws IllegalArgumentException {
        return notEmpty(s, null);
    }
    @NullInNullOut
    public static String notEmpty(String s, @Nullable String varName) throws IllegalArgumentException {
        if (s == null) return null;
        if (s.isEmpty()) {
            String msg = "Variable ";
            if (varName!=null) msg += varName;
            msg += " was empty!";
            throw new IllegalArgumentException(msg);
        }
        return s;
    }

    /**
     * Checks that the string is neither null nor empty.
     */
    @NotNull
    public static String notNullAndNotEmpty(String s) throws IllegalArgumentException {
        return notNullAndNotEmpty(s, null);
    }
    @NotNull
    public static String notNullAndNotEmpty(String s, @Nullable String varName) throws IllegalArgumentException {
        notNull(s, varName);
        notEmpty(s, varName);
        return s;
    }

    /**
     * String length measured in java chars.
     */
    @NullInNullOut
    public static String minLength(String s, int min, String varName) throws IllegalArgumentException {
        if (s==null) return null;
        if (s.length() < min) {
            String msg = "Variable ";
            if (varName!=null) msg += varName;
            msg += " too short, min="+min+" but was "+s.length()+", value was >>>"+s+"<<<!";
            throw new IllegalArgumentException(msg);
        }
        return s;
    }
    /**
     * String length measured in java chars.
     */
    @NullInNullOut
    public static String maxLength(String s, int max) throws IllegalArgumentException {
        return maxLength(s, max, null);
    }
    /**
     * String length measured in java chars.
     */
    @NullInNullOut
    public static String maxLength(String s, int max, @Nullable String varName) throws IllegalArgumentException {
        if (s==null) return null;
        if (s.length() > max) {
            String msg = "Variable ";
            if (varName!=null) msg += varName;
            msg += " too long, max="+max+" but was "+s.length()+", value was >>>"+s+"<<<!";
            throw new IllegalArgumentException(msg);
        }
        return s;
    }

    /**
     * String length measured in java chars.
     */
    @NullInNullOut
    public static String length(String s, int minIncl, int maxIncl, String varName) throws IllegalArgumentException {
        if (s==null) return null;
        minLength(s, minIncl, varName);
        maxLength(s, maxIncl, varName);
        return s;
    }

    /**
     * Allows the range 0-1, plus a reasonably small delta above 1 which can come from java's computation with double.
     * @deprecated this is ugly, it allows a delta over 1, but not under 0.
     */
    @Deprecated
    public static double rangeZeroToOne(double d, String varName) {
        if (d < 0d) {
            throw new IllegalArgumentException("Variable '"+varName+"' must be 0-1 but was smaller: "+ d +"!");
        }
        //i got 1.0000000000000002d so i allow 5x more difference
        if (d > 1.000000000000001d) {
            throw new IllegalArgumentException("Variable '"+varName+"' must be 0-1 but was larger: "+ d +"!");
        }
        return d;
    }

    /**
     * @see #rangeZeroToOne(double, String)
     */
    @NullInNullOut
    @Deprecated
    public static Double rangeZeroToOne(Double d, String varName) {
        if (d==null) return d;
        return rangeZeroToOne((double)d, varName);
    }

}
