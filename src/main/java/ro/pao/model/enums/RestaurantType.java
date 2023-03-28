package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor

public enum RestaurantType {
    ASIAN ("asiatic"),
    FASTFOOD("fast-food"),
    MEXICAN("mexican"),
    VEGAN("vegan"),
    NONE("none");

    private final String typeString;

    public static RestaurantType getEnumByFieldString(String field) {
        return Arrays.stream(RestaurantType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE); // in cazul in care nu este niciun field
    }
}
