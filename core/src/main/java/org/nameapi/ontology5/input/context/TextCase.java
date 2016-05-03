package org.nameapi.ontology5.input.context;

/**
 * Tells in what case of writing (upper, lower ...) the data is sent to the server.
 *
 * <p>This is used for caseful writing systems (including Latin and Cyrillic).
 * Writing systems that are caseless (such as Chinese) don't need this value.</p>
 *
 * <p>This is not about a single record, it's about all data in general.
 * Most data sources use {@link #TITLE_CASE}, but some legacy systems still use all
 * {@link #UPPER_CASE} writings.</p>
 *
 * <p>Data sources that also have content in multiple writing systems out of which
 * some are caseful and some are caseless (for example Chinese and English) must look
 * at those caseful values (English) and decide based on them.</p>
 *
 * <p>When {@link #TITLE_CASE} is used, but for example one record is written in all
 * lower case, then this indicates low data quality for that record. The NameAPI server
 * can then issue a warning.</p>
 *
 * @author sam
 */
public enum TextCase {

    /**
     * The strings are written with respect to case, for example proper names
     * usually start with an initial upper case.
     * <p>Example: "John Doe"</p>
     */
    TITLE_CASE,

    /**
     * All data is in upper case only.
     * <p>Example: "JOHN DOE"</p>
     * <p>Such data formats still exist in legacy systems.</p>
     */
    UPPER_CASE,

    /**
     * All data is in lower case only.
     * <p>Example: "john doe"</p>
     * <p>(It is very unlikely that you need this option.)</p>
     */
    LOWER_CASE;


    public boolean isIgnoreCase() {
        return this==LOWER_CASE || this==UPPER_CASE;
    }


    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int size) {
        assert values().length == size : "Update the code that calls this with outdated size "+size+"!";
    }

}
