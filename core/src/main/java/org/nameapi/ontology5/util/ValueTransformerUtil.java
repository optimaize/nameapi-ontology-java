package org.nameapi.ontology5.util;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriela Achim
 */
public class ValueTransformerUtil {

    /**
     * Transforms the field using the specified <code>transformer</code> and returns absent if the result is empty or null.
     */
    @NotNull
    public static Optional<String> transformOptionalStringField(@NotNull ValueTransformer transformer, @NotNull Optional<String> field) {
        if (!field.isPresent()) {
            return field;
        } else {
            String modified = transformer.transform(field.get());
            if (modified == null || modified.isEmpty()) {
                return Optional.absent();
            } else {
                if  (modified.equals(field.get())) {
                    return field;
                } else {
                    return Optional.of(modified);
                }
            }
        }
    }

    @NotNull
    public static List<String> transformStringList(@NotNull ValueTransformer transformer, @NotNull List<String> strings) {
        if (!strings.isEmpty()) {
            List<String> transformedStrings = new ArrayList<>(strings.size());
            for (String nationality : strings) {
                String modified = transformer.transform(nationality);
                if (modified != null && !modified.isEmpty()) {
                    transformedStrings.add(modified);
                }
            }
            return transformedStrings;
        }
        return strings;
    }


    @SafeVarargs
    public static boolean allAbsent(Optional<String> ... fields) {
        for (Optional<String> field : fields) {
            if (field.isPresent()) {
                return false;
            }
        }
        return true;
    }
}
