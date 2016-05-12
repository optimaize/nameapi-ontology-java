package org.nameapi.ontology5.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;

/**
 *
 */
public interface NameTransformer {

    @Nullable
    InputPersonName transform(@NotNull InputPersonName input);

}
