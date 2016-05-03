package org.nameapi.ontology5.cremalang.annotation;

/**
 * Usually used on methods like equals, hashCode and toString.
 *
 * <p>It tells that the code was not hand-written.</p>
 *
 * <p>Example: after adding a new field to a class the equals and hashCode methods need to be updated.
 * When those methods have the @GeneratedCode annotation then it's easy - delete the code and
 * regenerate in your IDE. If it looks like, but you're not sure, and it's not too short, then
 * good luck.</p>
 *
 * @author aa
 */
public @interface GeneratedCode {
}
