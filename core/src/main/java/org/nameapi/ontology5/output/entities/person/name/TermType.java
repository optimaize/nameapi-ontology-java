package org.nameapi.ontology5.output.entities.person.name;

/**
 * The classification of terms as returned by the server.
 *
 * @author sam
 * @author Nicole Torres
 * @author Fabian Kessler
 */
public enum TermType {

    /**
     * A given name (first name) or what is used as the person's given name, such as a short form,
     * nick name, diminutive, hypocorism or abbreviation.
     */
    GIVENNAME,

    /**
     * A surname or what is used as the person's surname, such as a family name, Icelandic patronym,
     * Arabic nisbah etc.
     */
    SURNAME,

    /**
     * A middle name or what is used as the person's middle name, such as a secondary given name,
     * surname (USA), Russian patronym, initial etc.
     */
    MIDDLENAME,

//    /**
//     * Reserved words for later use.
//     */
//    FATHERSGIVENNAME,
//    FATHERSGIVENNAMEINITIAL,

    /**
     * A person's nickname such as a hypocorism of the given name or anything else under which
     * the person is known.
     */
    NICKNAME,

    /**
     * The first letter of a given name such as "P", "P." or "H.P.".
     */
    GIVENNAMEINITIAL,
    /**
     * The first letters of a given name such as "Ghe." or "H.-P.".
     */
    GIVENNAMEABBREVIATION,

    /**
     * The first letter of a surname such as "P" or "P.".
     */
    SURNAMEINITIAL,

    /**
     *  The first letter of the middle name such as "N" or "N.".
     *  @since version 5.1
     */
    MIDDLENAMEINITIAL,

    /**
     * junior, senior
     */
    QUALIFIER,

    /**
     * Prof., Dr., ...
     */
    TITLE,

    /**
     * Mr., Herr, ...
     */
    SALUTATION,

    /**
     * Ph.D, ...
     */
    SUFFIX,


    PROFESSION,

    BUSINESSSECTOR,
    BUSINESSINDICATOR,
    BUSINESSLEGALFORM,
    BUSINESSNAME,

    /**
     * Née, born, geborene, ...
     *
     * http://en.wikipedia.org/wiki/Given_name#Name_at_birth
     *
     * it includes more cases than nee. nee is more restrictive, see wiki.
     * http://en.wikipedia.org/wiki/George_Michael
     *   George Michael born Georgios Kyriacos Panayiotou
     *   Lesley Angold (née Harrison)
     *
     * @since version 4.3
     */
    NAMEATBIRTHINDICATOR,
    /**
     * Also known as maiden name.
     *
     * This is a surname in the person's name that is not the current surname.
     * It may be identified as such by either a {@link #NAMEATBIRTHINDICATOR} or because it was entered
     * into a dedicated input field of type {@link org.nameapi.ontology5.input.entities.person.name.types.OtherNameFieldType#MAIDEN_SURNAME}.
     *
     * @since version 4.3
     */
    SURNAMEATBIRTH,
    /**
     * A surname that the person possessed at a previous time, but it is not a current surname anymore.
     *
     * Sometimes such surnames are added to the full name after a name change and/or as a discriminator.
     * A previous surname may be a surname at birth, but it doesn't need to be, we are not sure. It can be
     * the surname from before a divorce.
     *
     * @since version 5.0
     */
    PREVIOUSSURNAME,
    /**
     * Another surname that is not part of the current surname.
     *
     * It can be a surname at birth, or a previous surname, or it can be the current or former surname of the
     * husband/wife.
     *
     * @since version 5.0
     */
    OTHERSURNAME,

    /**
     * Examples: "c/o" (care of), "bei", "zu Handen".
     * Used in addresses only.
     * See https://en.wiktionary.org/wiki/care_of
     *
     * @since version 4.3
     */
    INTERMEDIARYINDICATOR,

    /**
     * Examples: "Germany", "Deutschland"
     * @since version 5.0
     */
    COUNTRYNAME,
    /**
     * Example: "New York"
     * @since version 5.1
     */
    PLACENAME,

    /**
     * Anything that was identified as a word where no other more specific term type was available.
     * @since version 5.1
     */
    WORD,

    ;


    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int size) {
        assert values().length == size : "Update the code that calls this with outdated size "+size+"!";
    }

}
