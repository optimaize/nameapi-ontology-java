
package org.nameapi.ontology5.services.matcher.personmatcher;

/**
 * The overall match type of how the names of one person match vs the names of another person.
 *
 * <p>Note that the definitions are not purely by character syntax; the decisions include culture specific logic.
 * For example in the Romanian "Claudia-Andreea" the hyphen is completely irrelevant, while in German "Hans-Peter" differs
 * from "Hans Peter".
 * Another example is the Dutch "ij" vs "y" spelling that is MATCHING (used interchangeably). Just like the Umlaut
 * "ü" vs "ue" in German. But a German variant Meyer vs Meier is a phonetic variation, and that downgrades to SIMILAR.
 * </p>
 *
 * <p>State: not all of the cases mentioned below are implemented as defined at this time. Some may give slightly different
 * results, for example MATCHING instead of EQUAL. They are defined as how we would like it all to behave, and we're
 * working towards these definitions.</p>
 *
 * @author Fabian Kessler
 * @author Nicole Torres
 */
public enum PersonNameMatchType {


    /**
     * The names match in full. Difference can only be in case and spacing, some punctuation, and meaningless
     * name garniture.
     *
     * Example for fully string-equal:
     * "Andre Müller" vs. "Andre Müller"
     *
     * <pre>
     * Permitted differences include:
     *
     *  - case
     *    "andre müller" vs. "Andre Müller" vs "Andre MÜLLER" vs "ANDRE MÜLLER"
     *
     *  - dot after abbreviation
     *    "Dr. P. Smith" vs "DR P SMITH"
     *
     *  - hyphen vs space in some cultures
     *    Example Romanian given name: "Claudia-Andreea Popescu" vs. "Claudia Andreea Popescu"
     *
     *  - a salutation is a meaningless name garniture unless it contradicts gender ("Mr. Andrea Meyer" vs. "Ms. Andrea Meyer").
     *    "Mr. Peter Meyer" vs. "Peter Meyer"
     * </pre>
     */
    EQUAL,

    /**
     * Not exactly equal, but no mismatch.
     *
     * <pre>
     * Specific cases include:
     *
     *  - Transcription and transliteration
     *    "André Muller" vs. "Andre Müller"
     *
     *  - Abbreviation and initial vs full
     *    "Andre Müller" vs. "A. Müller"
     *
     *  - one vs multiple names of a type
     *    examples:
     *    "Andre Müller"        vs. "Andre Müller-Meyer"
     *    "Andre Manuel Müller" vs. "Andre Müller"
     *    "Andrea Petra Müller" vs. "Andrea Müller-Meyer"
     *    "Andrea Petra Müller" vs. "Petra Müller-Meyer"
     *
     *  - name variant
     *    "Andre Müller" vs. "Andy Müller"
     *
     *  - title vs no title, title vs matching title
     *    "Dr. Andre Müller" vs. "Andre Müller"
     *
     *  - matching but not equal title
     *    "Dr. Andre Müller" vs. "Dr. med. dent. Andre Müller"
     *
     *  - qualifier vs no qualifier
     *    "Andre Müller jr." vs. "Andre Müller"
     *
     *  - different qualifiers that are not contradicting
     *    "Andre Müller jr." vs. "Andre Müller II"
     *
     *  - a detected misspelling of high confidence
     *    "Michael Meyer"    vs. "Mihcael Meyer"
     *
     *  - hyphen vs space in some cultures
     *    "Angela Meyer-Müller" vs. "Angela Meyer Müller"
     *    "Jean-Marie Bernard" vs. "Jean Marie Bernard"
     *
     *  - name order differs
     *    "Michael Thomas Meyer"  vs. "Thomas Michael Meyer"
     *    "Angela Meyer-Müller"   vs. "Angela Müller Meyer"
     * </pre>
     *
     */
    MATCHING,

    /**
     * The names are similar as a whole, nothing contradicts strongly, however, it's probably another person.
     *
     * <pre>
     * Specific cases include:
     *
     *  - name has a single, cheap modification (phonetic, typing)
     *    yet it is not identified as a sure misspelling
     *    "Peter Meyer" vs. "Peter Meier"
     *    "Karin Müller" vs. "Karim Müller"
     *
     *  - name is equal or matching, but has conflicting qualifier
     *    "Andre Müller jr." vs. "Andre Müller sr."
     *    "Andre Müller jr." vs. "Andre Müller I"
     *
     *  - conflicting gender (for example from title or salutation or profession)
     *    "Mr. Andrea Meyer" vs. "Ms. Andrea Meyer"
     *
     * </pre>
     */
    SIMILAR,

    /**
     * One of the names is equal, matching or similar enough, however, it's probably another person.
     *
     * <p>It could be the same person if there was a surname change (marriage etc), or it could be another person
     * of the same household (different given name, matching surname).</p>
     *
     * <p>Examples:
     * <ul>
     * <li>"Alexander Meyer"      vs. "Petra Meyer"</li>
     * <li>"Alexander Meyer"      vs. "Petra Meyer-Müller"</li>
     * <li>"Alexander Meyer"      vs. "Petra Meier"</li>
     * <li>"Petra Meyer"          vs. "Petra Müller"</li>
     * <li>"Petra Daniela Meyer"  vs. "Petra Müller"</li>
     * <li>"P. Meyer"             vs. "Petra Müller"</li>
     * <li>"P. Daniela Meyer"     vs. "Petra Müller"</li>
     * <li>"Daniela P. Meyer"     vs. "Petra Müller"</li>
     * </ul></p>
     *
     * <p>The cases with initials are disputable, but by definition it is as above. There is something similar, it is
     * better than records that have absolutely nothing similar, and from case to case it has to be decided.
     * Example: are 2 records possibly the same if one is P. Meyer and one is Petra Müller (now you'll say no way)
     * but what if the birth date and phone number are equal? You see, decide case by case how you use this result.</p>
     *
     * By definition also such cases are partial, but with lower points, and your use case must decide what you do
     * with the result.
     * <ul>
     * <li>"Alexander Meyer Huber"      vs. "Petra Meyer-Müller"</li>
     * <li>"Alexander Daniel Meyer"     vs. "Alexander Michael Müller"</li>
     * </ul>
     *
     * <p>Also, points should be lower for males with different surname than for females, because females change the
     * surname much more often.</p>
     *
     * @since 5.3
     */
    PARTIAL,

    /**
     * A neutral "nothing found".
     * <p>Unlikely the same person.</p>
     */
    NO_SIMILARITY_FOUND,

    /**
     * The names are different and so are the people.
     * <p>Unless the two names are snapshots of the same person take at different times (think marriage).</p>
     */
    DIFFERENT,
    ;


    public static void assertSize(int size) {
        assert values().length==size : "Update the code calling PersonNameMatchType.assertSize() with outdated "+size+" instead of "+values().length+"!";
    }

}
