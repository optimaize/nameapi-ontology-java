package org.nameapi.ontology5.services.matcher.personmatcher;

import junit.framework.TestCase;

/**
 * @author gabriela
 */
public class PlaceMatchTypeTest extends TestCase {

    public void testIsEqualOrBetterThan() throws Exception {
        assertTrue(PlaceMatchType.EQUAL.isEqualOrBetterThan(PlaceMatchType.EQUAL));
        assertTrue(PlaceMatchType.EQUAL.isEqualOrBetterThan(PlaceMatchType.MATCHING));
        assertTrue(PlaceMatchType.EQUAL.isEqualOrBetterThan(PlaceMatchType.SIMILAR));
        assertTrue(PlaceMatchType.EQUAL.isEqualOrBetterThan(PlaceMatchType.EQUAL));

        assertFalse(StreetMatchType.SIMILAR.isWorseThan(StreetMatchType.DIFFERENT));
    }

    public void testIsEqualOrWorseThan() throws Exception {
        assertTrue(PlaceMatchType.DIFFERENT.isEqualOrWorseThan(PlaceMatchType.MATCHING));
        assertTrue(PlaceMatchType.DIFFERENT.isEqualOrWorseThan(PlaceMatchType.SIMILAR));
        assertTrue(PlaceMatchType.DIFFERENT.isEqualOrWorseThan(PlaceMatchType.EQUAL));
        assertTrue(PlaceMatchType.MATCHING.isEqualOrWorseThan(PlaceMatchType.EQUAL));
        assertTrue(PlaceMatchType.EQUAL.isEqualOrWorseThan(PlaceMatchType.EQUAL));

        assertFalse(PlaceMatchType.EQUAL.isEqualOrWorseThan(PlaceMatchType.SIMILAR));
    }

    public void testIsWorseThan() throws Exception {
        assertTrue(PlaceMatchType.DIFFERENT.isWorseThan(PlaceMatchType.MATCHING));
        assertTrue(PlaceMatchType.DIFFERENT.isWorseThan(PlaceMatchType.SIMILAR));
        assertTrue(PlaceMatchType.DIFFERENT.isWorseThan(PlaceMatchType.EQUAL));
        assertTrue(PlaceMatchType.MATCHING.isWorseThan(PlaceMatchType.EQUAL));

        assertFalse(PlaceMatchType.EQUAL.isWorseThan(PlaceMatchType.SIMILAR));
        assertFalse(PlaceMatchType.EQUAL.isWorseThan(PlaceMatchType.EQUAL));
    }
}
