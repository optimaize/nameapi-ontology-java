package org.nameapi.ontology5.cremalang.annotation;

/**
 * Marks a method to return null in the case of null input.
 *
 * <p>In most cases it also means that the method only returns null if the input was null,
 * not otherwise, but this is just a convention. Not following this convention should be
 * documented.</p>
 *
 * <p>This is information for the human, but could also be used by tools, for example to verify and warn.</p>
 *
 * @author aa
 */
public @interface NullInNullOut {
}
