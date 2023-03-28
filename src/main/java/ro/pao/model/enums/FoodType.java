package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor

public enum FoodType {
    MAINCOURSE("main-course"),
    DRINK("drink"),
    DESSERT("dessert"),
    APPETIZER("appetizer"),
    NONE("none");

    private final String typeString;

    public static FoodType getEnumByFieldString(String field) {
        return Arrays.stream(FoodType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE); // in cazul in care nu este niciun field
    }
}