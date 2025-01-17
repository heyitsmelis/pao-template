package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.RestaurantMapper;
import ro.pao.model.Restaurant;
import ro.pao.repository.RestaurantRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RestaurantRepositoryImpl implements RestaurantRepository {

    private static final RestaurantMapper restaurantMapper = RestaurantMapper.getInstance();

    @Override
    public Optional<Restaurant> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM restaurant WHERE restaurant_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return RestaurantMapper.mapRestaurantClass(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM restaurant WHERE restaurant_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Restaurant newObject) {
        String updateNameSql = "UPDATE restaurant SET restaurant_name=? WHERE restaurant_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newObject.getRestaurantStringField());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Restaurant restaurant) {
        String insertSql = "INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_address, restaurant_type) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, restaurant.getId().toString());
            preparedStatement.setString(2, restaurant.getRestaurantStringField());
            preparedStatement.setString(3, restaurant.getRestaurantStringField());
            preparedStatement.setString(4, String.valueOf(restaurant.getRestaurantType()));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Restaurant> getAll() {
        String selectSql = "SELECT * FROM restaurant";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return RestaurantMapper.mapToRestaurantList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Restaurant> restaurantList) {
        restaurantList.forEach(this::addNewObject);
    }
}
