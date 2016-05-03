package org.nameapi.ontology5.input.entities.address;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * @author sam
 */
public abstract class BaseStreetInfo implements StreetInfo {

    @NotNull @Override
    public List<String> getAsLines() {
        return Collections.singletonList(getAsString());
    }

    @NotNull @Override
    public Optional<String> getStreetNameAndNumber() {
        return Optional.absent();
    }

    @NotNull @Override
    public Optional<String> getAddressLine2() {
        return Optional.absent();
    }

    @NotNull @Override
    public Optional<String> getStreetName() {
        return Optional.absent();
    }

    @NotNull @Override
    public Optional<String> getStreetNumber() {
        return Optional.absent();
    }

    @NotNull @Override
    public Optional<String> getBuilding() {
        return Optional.absent();
    }

    @NotNull @Override
    public Optional<String> getStaircase() {
        return Optional.absent();
    }

    @NotNull @Override
    public Optional<String> getFloor() {
        return Optional.absent();
    }

    @NotNull @Override
    public Optional<String> getApartment() {
        return Optional.absent();
    }
}
