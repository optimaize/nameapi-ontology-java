package org.nameapi.ontology5.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.input.context.Context;

/**
 *
 * @author Nicole Torres
 */
public abstract class ObjectInput {

    private final Optional<Context> context;

    @JsonCreator
    public ObjectInput(
            @JsonProperty("context") @Nullable Context context
    ) {
        this.context = Optional.fromNullable(context);
    }

    public Optional<Context> getContext() {
        return context;
    }

}
