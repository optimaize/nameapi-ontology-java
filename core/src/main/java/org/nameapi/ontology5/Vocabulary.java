package org.nameapi.ontology5;

/**
 * Dictionary for terms used.
 *
 * <p>Javadoc can link to these values with details explanations, instead of copy/pasting the same limited
 * and possibly outdated text.</p>
 *
 * @author sam
 * @author Nicole Torres
 * @author Fabian Kessler
 */
public enum Vocabulary {

    /*
    Even though Java enums follow the convention to have all values in UPPER CASE,
    there is no need to follow this pattern here. Use the terms in the case that
    they appear in code.
     */

    /**
     * The api-key also known as user-id.
     *
     * <p>Authentication and accounting is performed on the server for this key.</p>
     *
     * <p>Do not make this key public unless you have to, for example when used by JavaScript Ajax requests in a
     * website. It's possible to restrict the hosts that are allowed to use this api-key in your admin panel.</p>
     *
     * <p>Format: The 32 hexa-digits md5 of the base account (such as "9e107d9d372bb6826bd81d3542a419d6") plus
     * the user account specific suffix separated by hyphen, resulting in something like
     * "9e107d9d372bb6826bd81d3542a419d6-defaultuser".</p>
     */
    apiKey,

    /**
     * The geographic area from where the request is coming.
     *
     * <p>This helps the server to better understand and classify the incoming data.
     * Example: the given name "Andrea" is female in Germany but male in Italy.</p>
     *
     * <p>Value: A geographic code such as an ISO-3166 two letter country code, for example "FR" for France.</p>
     *
     * <p>If the request is made in behalf of another company then the place may be adjusted to that.
     * However, it is not meant to be set for the target customer.
     * Example: Your company mainly operates in France (FR), and is the service provider for another
     * company in Italy (IT), and the customer used in this web service request happens to be from
     * Austria (AT), then the place should be set to "IT".</p>
     *
     * <p>Technical note: when the system needs a Locale it uses the {@code place} with the {@link #language}.</p>
     */
    place,

    /**
     * The language used for locale-sensitive operations such as converting a string to upper case.
     *
     * <p>This is usually the primary language matching the {@link #place}, for example German for Germany.</p>
     *
     * <p>If not provided, and {@link #place} is available, the primary language for that place is used.</p>
     *
     * <p>Value: A language code such as an ISO-639-1 two letter code, for example "fr" for French.</p>
     *
     * <p>Technical note: when the system needs a Locale it uses the {@link #place} with the {@code language}.</p>
     */
    language,

    /**
     * The writing system(s) used in the data source.
     * <p>One code starts with the ISO 15924 script name, optionally followed by the ISO 639-1 or
     * ISO 639-3 language code.</p>
     * <p>Examples: "Latn:de", "Latn:gsw", "Cyrl:ru".</p>
     * <p>Multiple writing systems may be used, for example "Cyrl:sr" plus "Latn:sr".</p>
     * <p>The special non-standard script name "Asci" is used for the us-ascii character set.</p>
     *
     * <p>This hint helps the server to match terms with its databases, and generate better results.
     * Also, the user may be warned when accidentally using characters not in his range, for example
     * when a Cyrillic character slipped into his Latin customer database (which may be visually
     * indistinguishable).</p>
     */
    writingSystem,

    /**
     * Arguments to send to the server.
     *
     * <p>There are a few public properties. And custom properties may be created for customers to
     * customize server behavior for their needs.</p>
     */
    contextProperties,

    /**
     * Information about a person's age.
     *
     * <p>For a NaturalPerson this is the birth-date/age info. For a LegalPerson this is the founding
     * date (activation date).</p>
     *
     * <p><b>Usage:</b>
     * Depends on the service.
     * A validator service may check for valid dates, and report problems (such as 1986-02-31).
     * A genderizer service may use it to filter irrelevant birth statistics.
     * </p>
     *
     * <p><b>Invalid input:</b>
     * The behavior on illegal input depends on the web service that is called. Invalid (xml) input
     * such as a non-numeric string should always result in an illegal input exception. An invalid date
     * such as 1986-02-31 may trigger an illegal input exception, or it may just be ignored.
     * </p>
     */
    ageInfo,

    /**
     * Addresses that are used by this person.
     *
     * <p>Multiple addresses may be passed (domicile, mailing/delivery address, ...) or a single address may be
     * responsible for all purposes. </p>
     *
     * <p><b>Usage:</b>
     * Depends on the service.
     * A validator service may check for valid addresses, and report problems (such as invalid zip codes).
     * A genderizer service may use it to better classify the names.
     * </p>
     *
     * <p><b>Invalid input:</b>
     * The behavior on illegal input depends on the web service that is called.
     * A validator service may report problems with an address. Other services mostly just ignore
     * invalid address data as it is not their task to validate, and the information is just helping
     * to better understand the input and is not essential.
     * </p>
     */
    addresses,

    /**
     * Phone, fax etc numbers that are used by this person.
     *
     * <p>Multiple numbers may be added.</p>
     *
     * <p><b>Usage:</b>
     * Depends on the service.
     * A data validator service may check for problems.
     * A fake checker may look for suspicious input.
     * </p>
     *
     * <p><b>Invalid input:</b>
     * The behavior on illegal input depends on the web service that is called.
     * A validator service may report problems with an address. Other services mostly just ignore
     * invalid phone data as it is not their task to validate, and the information is just helping
     * to better understand the input and is not essential.
     * </p>
     */
    telNumbers,

    /**
     * Email addresses that are used by this person.
     *
     * <p>Multiple addresses may be added.</p>
     *
     * <p><b>Usage:</b>
     * Depends on the service.
     * A data validator service may check for problems such as illegal syntax or inexistent domain.
     * A service may check for disposable email addresses.
     * It may be used to extract name information.
     * A validator service may compare the name in the email address with the person's name.
     * </p>
     *
     * <p><b>Invalid input:</b>
     * The behavior on illegal input depends on the web service that is called.
     * A validator service may report problems with invalid email address syntax, or inexistent domain
     * names, etc.
     * Services may throw an invalid input exception.
     * </p>
     */
    emailAddresses,

    /**
     * The language code for the correspondence language of the person (with you, the company).
     *
     * <p>ISO-639 code of the language. Either 639-1 or 639-3, for example "it" or "ita" for Italian.</p>
     *
     * <p><b>Usage:</b>
     * In combination with the Context.place it helps the services to better classify the culture of the person.
     * </p>
     *
     * <p><b>Invalid input:</b>
     * The behavior on illegal input depends on the web service that is called.
     * It may ignore it, or throw an invalid input exception.
     * </p>
     */
    correspondenceLanguage

}
