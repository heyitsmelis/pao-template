package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.ClientMapper;
import ro.pao.repository.ClientRepository;
import ro.pao.model.Client;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientRepositoryImpl implements ClientRepository {

    private static final ClientMapper clientMapper = ClientMapper.getInstance();

    @Override
    public Optional<Client> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM client WHERE client_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return ClientMapper.mapClientClass(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM client WHERE client_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Client newObject) {
        String updateNameSql = "UPDATE client SET user_name=? WHERE client_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newObject.getClientStringField());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Client client) {
        String insertSql = "INSERT INTO client (driver_id, first_name, last_name,user_name) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, client.getId().toString());
            preparedStatement.setString(2, client.getClientStringField());
            preparedStatement.setString(3, client.getClientStringField());
            preparedStatement.setString(4, client.getClientStringField());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAll() {
        String selectSql = "SELECT * FROM client";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return ClientMapper.mapToClientList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Client> clientList) {
        clientList.forEach(this::addNewObject);
    }
}

