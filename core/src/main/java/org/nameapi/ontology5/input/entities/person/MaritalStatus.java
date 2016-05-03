package org.nameapi.ontology5.input.entities.person;

import org.jetbrains.annotations.Nullable;

/**
 * Defines the person's marital status.
 *
 * @author sam
 */
public enum MaritalStatus {

    UNKNOWN(null, null),
    SINGLE(false, false),
    ENGAGED(null, true), //TODO what's the status of a divorced, re-enganged person? this might depend on the culture.
    MARRIED(true, true),
    SEPARATED(true, true),
    DIVORCED(true, true),
    WIDOWED(true, true);

    MaritalStatus(@Nullable Boolean isOrWasMarried, @Nullable Boolean isOrWasEngagedOrMarried) {
        this.isOrWasMarried = isOrWasMarried;
        this.isOrWasEngagedOrMarried = isOrWasEngagedOrMarried;
    }

    @Nullable
    private Boolean isOrWasMarried;
    @Nullable
    private Boolean isOrWasEngagedOrMarried;

    @Nullable
    public Boolean getIsOrWasMarried() {
        return isOrWasMarried;
    }
    @Nullable
    public Boolean getIsOrWasEngagedOrMarried() {
        return isOrWasEngagedOrMarried;
    }

    public boolean isUnknown() {
        return this == UNKNOWN;
    }


    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int size) {
        assert values().length == size : "Update the code that calls this with outdated size "+size+"!";
    }

}
