package ro.pao.mapper;


import ro.pao.model.Order;
import ro.pao.model.enums.OrderType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderMapper {

    private static final OrderMapper INSTANCE = new OrderMapper();

    private OrderMapper() {
    }

    public static OrderMapper getInstance() {
        return INSTANCE;
    }


    public static Optional<Order> mapOrderClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Order.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .userName(resultSet.getString(2))
                            .restaurantName(resultSet.getString(3))
                            .foodName(resultSet.getString(4))
                            .orderType(OrderType.valueOf(resultSet.getString(5)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public static List<Order> mapToOrderList(ResultSet resultSet) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        while (resultSet.next()) {
            orderList.add(
                    Order.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .userName(resultSet.getString(2))
                            .restaurantName(resultSet.getString(3))
                            .foodName(resultSet.getString(4))
                            .orderType(OrderType.valueOf(resultSet.getString(5)))
                            .build()
            );
        }

        return orderList;
    }
}
