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

    private UUID userId;
    private UUID restaurantId;
    private List<Food> orderList;
    private OrderType orderType;

}
