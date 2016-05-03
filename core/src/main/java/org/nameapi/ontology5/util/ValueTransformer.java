package org.nameapi.ontology5.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Gets the chance to transform values.
 *
 * This is used in the various value objects. They are immutable, but they can return copies with
 * possibly modified values.
 *
 * An example use case is trimming strings.
 *
 * After the transformer is done, it's possible that nothing is left. For example the value " " gets trimmed
 * and then it's the empty string. Such objects are not permitted. In those cases the transformer returns
 * null. Optional.absent() cannot be returned, we must use null instead. That's because with generics it would
 * become very, very messy.
 *
 * @author Fabian Kessler
 */
public interface ValueTransformer {

    @Nullable
    String transform(@NotNull String input);

}
