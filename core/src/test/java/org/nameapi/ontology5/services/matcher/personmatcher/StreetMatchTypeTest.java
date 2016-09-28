package org.nameapi.ontology5.services.matcher.personmatcher;

import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * @author gabriela
 */
public class StreetMatchTypeTest extends TestCase {
    @Test
    public void testIsEqualOrBetterThan() throws Exception {
        assertTrue(StreetMatchType.EQUAL.isEqualOrBetterThan(StreetMatchType.EQUAL));
        assertTrue(StreetMatchType.EQUAL.isEqualOrBetterThan(StreetMatchType.MATCHING));
        assertTrue(StreetMatchType.EQUAL.isEqualOrBetterThan(StreetMatchType.SIMILAR));
        assertTrue(StreetMatchType.EQUAL.isEqualOrBetterThan(StreetMatchType.EQUAL));

        assertFalse(StreetMatchType.SIMILAR.isWorseThan(StreetMatchType.DIFFERENT));
    }
    @Test
    public void testIsEqualOrWorseThan() throws Exception {
        assertTrue(StreetMatchType.DIFFERENT.isEqualOrWorseThan(StreetMatchType.MATCHING));
        assertTrue(StreetMatchType.DIFFERENT.isEqualOrWorseThan(StreetMatchType.SIMILAR));
        assertTrue(StreetMatchType.DIFFERENT.isEqualOrWorseThan(StreetMatchType.EQUAL));
        assertTrue(StreetMatchType.MATCHING.isEqualOrWorseThan(StreetMatchType.EQUAL));
        assertTrue(StreetMatchType.EQUAL.isEqualOrWorseThan(StreetMatchType.EQUAL));

        assertFalse(StreetMatchType.EQUAL.isEqualOrWorseThan(StreetMatchType.SIMILAR));
    }
    @Test
    public void testIsWorseThan() throws Exception {
        assertTrue(StreetMatchType.DIFFERENT.isWorseThan(StreetMatchType.MATCHING));
        assertTrue(StreetMatchType.DIFFERENT.isWorseThan(StreetMatchType.SIMILAR));
        assertTrue(StreetMatchType.DIFFERENT.isWorseThan(StreetMatchType.EQUAL));
        assertTrue(StreetMatchType.MATCHING.isWorseThan(StreetMatchType.EQUAL));

        assertFalse(StreetMatchType.EQUAL.isWorseThan(StreetMatchType.SIMILAR));
        assertFalse(StreetMatchType.EQUAL.isWorseThan(StreetMatchType.EQUAL));
    }
}
