package ro.pao.mapper;


import ro.pao.model.Food;
import ro.pao.model.enums.FoodType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FoodMapper {

    private static final FoodMapper INSTANCE = new FoodMapper();

    private FoodMapper() {
    }

    public static FoodMapper getInstance() {
        return INSTANCE;
    }


    public static Optional<Food> mapFoodClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Food.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .foodName(resultSet.getString(2))
                            .foodPrice(resultSet.getFloat(3))
                            .foodCalories(resultSet.getFloat(4))
                            .foodType(FoodType.valueOf(resultSet.getString(5)))
                            .foodQuantity(resultSet.getInt(6))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public static List<Food> mapToFoodList(ResultSet resultSet) throws SQLException {
        List<Food> foodList = new ArrayList<>();
        while (resultSet.next()) {
            foodList.add(
                    Food.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .foodName(resultSet.getString(2))
                            .foodPrice(resultSet.getFloat(3))
                            .foodCalories(resultSet.getFloat(4))
                            .foodType(FoodType.valueOf(resultSet.getString(5)))
                            .foodQuantity(resultSet.getInt(6))
                            .build()
            );
        }

        return foodList;
    }
}