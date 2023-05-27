package ro.pao.mapper;


import ro.pao.model.Restaurant;
import ro.pao.model.enums.RestaurantType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RestaurantMapper {

    private static final RestaurantMapper INSTANCE = new RestaurantMapper();

    private RestaurantMapper() {
    }

    public static RestaurantMapper getInstance() {
        return INSTANCE;
    }


    public static Optional<Restaurant> mapRestaurantClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Restaurant.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .shopName(resultSet.getString(2))
                            .shopAdress(resultSet.getString(3))
                            .restaurantType(RestaurantType.valueOf(resultSet.getString(4)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public static List<Restaurant> mapToRestaurantList(ResultSet resultSet) throws SQLException {
        List<Restaurant> restaurantList = new ArrayList<>();
        while (resultSet.next()) {
            restaurantList.add(
                    Restaurant.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .shopName(resultSet.getString(2))
                            .shopAdress(resultSet.getString(3))
                            .restaurantType(RestaurantType.valueOf(resultSet.getString(4)))
                            .build()
            );
        }

        return restaurantList;
    }
}