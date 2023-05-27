package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.FoodMapper;
import ro.pao.model.Food;
import ro.pao.repository.FoodRepository;

import java.security.cert.Extension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FoodRepositoryImpl implements FoodRepository {

    private static final FoodMapper foodMapper = FoodMapper.getInstance();

    @Override
    public Optional<Food> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM food WHERE food_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return FoodMapper.mapFoodClass(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM food WHERE food_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Food newObject) {
        String updateNameSql = "UPDATE food SET food_name=? WHERE food_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newObject.getFoodStringField());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Food food) {
        String insertSql = "INSERT INTO food (food_id, food_name, food_price, food_calories,food_type,food_quantity,restaurant_id) VALUES (?, ?, ?, ?, ?, ?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, food.getId().toString());
            preparedStatement.setString(2, food.getFoodStringField());
            preparedStatement.setFloat(3,food.getFoodPrice());
            preparedStatement.setFloat(4,food.getFoodCalories());
            preparedStatement.setString(5, String.valueOf(food.getFoodType()));
            preparedStatement.setFloat(6,food.getFoodQuantity());
            preparedStatement.setString(7,food.getId().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Food> getAll() {
        String selectSql = "SELECT * FROM food";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return FoodMapper.mapToFoodList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Food> foodList) {
        foodList.forEach(this::addNewObject);
    }
}
