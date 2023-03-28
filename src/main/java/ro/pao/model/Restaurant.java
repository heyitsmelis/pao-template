package ro.pao.model;

import lombok.*;
import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.model.enums.RestaurantType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Restaurant extends AbstractEntity {

    private String shopName;

    private String shopAdress;

    private RestaurantType restaurantType;
}
