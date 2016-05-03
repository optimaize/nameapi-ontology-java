package org.nameapi.ontology5.input.entities.person.gender;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Converts from one enum type to another.
 *
 * <p>Obviously not all conversions are possible.
 * Add more functionality as needed. For example lossful conversion methods that return null when there is no
 * corresponding value
 *
 * @author sam
 */
@SuppressWarnings({"JavaDoc"})
public class GenderConverter {

    private GenderConverter() {
        throw new Error("No instance!");
    }


    /**
     * @return male to male, female to female, and unknown to <code>null</code>.
     */
    @Nullable
    public static EffectivePersonGender toEffectiveGender(@NotNull StoragePersonGender storageGender) {
        if (storageGender.isMale())   return EffectivePersonGender.MALE;
        if (storageGender.isFemale()) return EffectivePersonGender.FEMALE;
        return null;
    }


    /**
     * All {@link EffectivePersonGender} fit into {@link StoragePersonGender}.
     */
    @NotNull
    public static StoragePersonGender toStorageGender(@NotNull EffectivePersonGender effectiveGender) {
        return StoragePersonGender.valueOf(effectiveGender.name());
    }


    /**
     * All {@link EffectivePersonGender} fit into {@link ComputedPersonGender}.
     */
    @NotNull
    public static ComputedPersonGender toComputedGender(@NotNull EffectivePersonGender effectiveGender) {
        return ComputedPersonGender.valueOf(effectiveGender.name());
    }


    /**
     * All {@link StoragePersonGender} fit into {@link ComputedPersonGender}.
     */
    @NotNull
    public static ComputedPersonGender toComputedGender(@NotNull StoragePersonGender storageGender) {
        return ComputedPersonGender.valueOf(storageGender.name());
    }

}
