package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum VehicleType {
    CAR("car"),
    MOTORCYCLE("motorcycle"),
    BICYCLE("bicycle"),
    NONE("none");

    private final String typeString;

    public static VehicleType getEnumByFieldString(String field) {
        return Arrays.stream(VehicleType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE); // in cazul in care nu este niciun field
    }

}
