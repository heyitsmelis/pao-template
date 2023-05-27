package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.OrderMapper;
import ro.pao.model.Order;
import ro.pao.repository.OrderRepository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderRepositoryImpl implements OrderRepository {

    private static final OrderMapper orderMapper = OrderMapper.getInstance();

    @Override
    public Optional<Order> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM ordering WHERE order_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return OrderMapper.mapOrderClass(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM ordering WHERE order_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void AddDriverById(UUID id, Order newObject) {
        String updateNameSql = "UPDATE ordering SET driver_id=? WHERE order_id=? AND order_type='Delivery'";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newObject.getOrderStringField());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Order order) {
        String insertSql = "INSERT INTO ordering (order_id, client_id, restaurant_id, food_id,order_type ) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, order.getId().toString());
            preparedStatement.setString(2, order.getId().toString());
            preparedStatement.setString(3,order.getId().toString());
            preparedStatement.setString(4,order.getId().toString());
            preparedStatement.setString(5, String.valueOf(order.getOrderType()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAll() {
        String selectSql = "SELECT * FROM ordering";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return OrderMapper.mapToOrderList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Order> orderList) {
        orderList.forEach(this::addNewObject);
    }
}