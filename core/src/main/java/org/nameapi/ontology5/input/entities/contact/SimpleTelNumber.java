package org.nameapi.ontology5.input.entities.contact;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.util.ValueTransformer;

/**
 * Simple implementation that does not specify any more detail such as separated
 * country code or area prefix.
 *
 * <p>Code example:
 * <code>TelNumber telNumber = new SimpleTelNumber("+33 3 86 30 77 88");</code>
 * </p>
 *
 * @author Nicole Torres
 */
final class SimpleTelNumber implements TelNumber {

    @NotNull
    private final String fullNumber;

    /**
     * @see TelNumber#getFullNumber()
     * @param fullNumber The complete number in any format. Not empty.
     */
    public SimpleTelNumber(@NotNull String fullNumber) {
        if (fullNumber.isEmpty()) {
            throw new IllegalArgumentException("Number may not be empty!");
        }
        this.fullNumber = fullNumber;
    }

    @NotNull @Override
    public String getFullNumber() {
        return fullNumber;
    }

    @Nullable
    @Override
    public TelNumber transform(@NotNull ValueTransformer transformer) {
        String modified = transformer.transform(fullNumber);
        if (modified==null || modified.isEmpty()) return null;
        if (fullNumber.equals(modified)) return this;
        return new SimpleTelNumber(modified);
    }


    @Override
    public String toString() {
        return "SimpleTelNumber{" +
                "fullNumber='" + fullNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleTelNumber that = (SimpleTelNumber) o;

        if (!fullNumber.equals(that.fullNumber)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return fullNumber.hashCode();
    }
}
