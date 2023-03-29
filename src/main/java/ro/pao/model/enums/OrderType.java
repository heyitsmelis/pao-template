package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ro.pao.model.Order;

import java.util.Arrays;
@Getter
@AllArgsConstructor
public enum OrderType {
    DELIVERY("delivery"),

    PICK_UP("pick-up"),

    NONE("none");

    private final String typeString;

    public static OrderType getEnumByFieldString(String field) {
        return Arrays.stream(OrderType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE); // in cazul in care nu este niciun field
    }
}
