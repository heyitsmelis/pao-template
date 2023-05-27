package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.IngredientMapper;
import ro.pao.model.Ingredient;
import ro.pao.repository.IngredientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class IngredientRepositoryImpl implements IngredientRepository {

    private static final IngredientMapper ingredientMapper = IngredientMapper.getInstance();

    @Override
    public Optional<Ingredient> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM ingredient WHERE ingredient_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return IngredientMapper.mapIngredientClass(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM ingredient WHERE ingredient_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Ingredient newObject) {
        String updateNameSql = "UPDATE ingredient SET ingredient_name=? WHERE ingredient_id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newObject.getIngredientStringField());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Ingredient ingredient) {
        String insertSql = "INSERT INTO ingredient (ingredient_id, ingredient_name) VALUES (?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, ingredient.getId().toString());
            preparedStatement.setString(2, ingredient.getIngredientStringField());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ingredient> getAll() {
        String selectSql = "SELECT * FROM ingredient";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return IngredientMapper.mapToIngrList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Ingredient> ingredientList) {
        ingredientList.forEach(this::addNewObject);
    }
}
