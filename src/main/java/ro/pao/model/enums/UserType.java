package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum UserType {
    CLIENT("client"),
    DELIVERY("delivery"),
    NONE("none"); // in cazul in care nu este niciun field

    private final String typeString;

    public static UserType getEnumByFieldString(String field) {
        return Arrays.stream(UserType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE); // in cazul in care nu este niciun field
    }
}
