package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.DriverMapper;
import ro.pao.repository.DriverRepository;
import ro.pao.model.Driver;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DriverRepositoryImpl implements DriverRepository {

    private static final DriverMapper driverMapper = DriverMapper.getInstance();

    @Override
    public Optional<Driver> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM driver WHERE driver_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return DriverMapper.mapDriverClass(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM driver WHERE driver_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Driver newObject) {
        String updateNameSql = "UPDATE driver SET user_name=? WHERE driver_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newObject.getDriverStringField());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Driver driver) {
        String insertSql = "INSERT INTO driver (driver_id, first_name, last_name,user_name, vehicle_type) VALUES (?, ?, ?, ?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, driver.getId().toString());
            preparedStatement.setString(2, driver.getDriverStringField());
            preparedStatement.setString(3, driver.getDriverStringField());
            preparedStatement.setString(4, driver.getDriverStringField());
            preparedStatement.setString(5, String.valueOf(driver.getVehicleType()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Driver> getAll() {
        String selectSql = "SELECT * FROM driver";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return DriverMapper.mapToDriverList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Driver> driverList) {
        driverList.forEach(this::addNewObject);
    }
}
