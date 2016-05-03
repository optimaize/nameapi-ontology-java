package org.nameapi.ontology5.input.entities.address;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;

/**
 * @author sam
 */
public abstract class BasePlaintextAddress extends BaseAddress implements InputAddress {

    @NotNull @Override
    public Optional<String> getPobox() {
        return Optional.absent();
    }
    @NotNull @Override
    public Optional<StreetInfo> getStreetInfo() {
        return Optional.absent();
    }

}
