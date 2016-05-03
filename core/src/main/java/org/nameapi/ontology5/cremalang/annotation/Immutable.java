package org.nameapi.ontology5.cremalang.annotation;

/**
 * Marks a class explicitly as "immutable".
 *
 * <p>This is information for the human, but could also be used by tools, for example to verify and warn
 * when some kind of mutability could slip in.</p>
 *
 * <p>Note: there are multiple levels of immutability. The annotation could use an attribute that
 * specifies the level.</p>
 *
 * @author aa
 */
public @interface Immutable {
}
