package ro.pao.model;

import lombok.*;
import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.model.enums.OrderType;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Order extends AbstractEntity {
    private UUID id;

    private String userName;
    private String restaurantName;
    private String foodName;
    private OrderType orderType;

    public Order(String userName, String restaurantName, String foodName, OrderType orderType) {
    }

    public String getOrderStringField() {
        return null;
    }
}
