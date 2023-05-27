package ro.pao.model;

import lombok.*;
import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.model.enums.FoodType;
import ro.pao.model.enums.RestaurantType;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Restaurant extends AbstractEntity {
    private UUID id;
    private String shopName;

    private String shopAdress;

    private RestaurantType restaurantType;

    public Restaurant(String shopName, String shopAdress, RestaurantType restaurantType) {
    }

    public String getRestaurantStringField() {
        return null;
    }

    //private Map<FoodType,Food> meniuMap;
}
