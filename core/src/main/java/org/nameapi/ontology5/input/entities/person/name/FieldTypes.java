package org.nameapi.ontology5.input.entities.person.name;

import com.google.common.collect.ImmutableList;
import org.nameapi.ontology5.input.entities.person.name.types.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility methods for working with {@link FieldType}s.
 *
 * @author sam
 */
public class FieldTypes {

    public static boolean isGivenName(FieldType fieldType) {
        return fieldType.name().equals("GIVENNAME");
    }
    public static boolean isMiddleName(FieldType fieldType) {
        return fieldType.name().equals("MIDDLENAME");
    }
    public static boolean isSurname(FieldType fieldType) {
        return fieldType.name().equals("SURNAME");
    }



    private static final List<FieldType> allValues;
    static {
        List<FieldType> values = new ArrayList<>();
        Collections.addAll(values, AmericanNameFieldType.values());
        Collections.addAll(values, ArabicNameFieldType.values());
        Collections.addAll(values, CommonNameFieldType.values());
        Collections.addAll(values, LegalNameFieldType.values());
        Collections.addAll(values, OtherNameFieldType.values());
        Collections.addAll(values, WesternNameFieldType.values());
        allValues = ImmutableList.copyOf(values);
    }

    public static List<FieldType> getAllValues() {
        return allValues;
    }

    /**
     * Converts a string to the enum value.
     * @param s in upper case
     * @throws IllegalArgumentException if inexistent
     */
    public static FieldType valueOf(String s) throws IllegalArgumentException {
        for (FieldType fieldType : getAllValues()) {
            if (fieldType.toString().equals(s)) {
                return fieldType;
            }
        }
        throw new IllegalArgumentException("No FieldType value exists for string >>>"+s+"<<<!");
    }

}
