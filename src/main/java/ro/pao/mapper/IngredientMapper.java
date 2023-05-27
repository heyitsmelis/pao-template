package ro.pao.mapper;


import ro.pao.model.Ingredient;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class IngredientMapper {

    private static final IngredientMapper INSTANCE = new IngredientMapper();

    private IngredientMapper() {
    }

    public static IngredientMapper getInstance() {
        return INSTANCE;
    }


    public static Optional<Ingredient> mapIngredientClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Ingredient.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .ingredientName(resultSet.getString(2))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public static List<Ingredient> mapToIngrList(ResultSet resultSet) throws SQLException {
        List<Ingredient> ingrList = new ArrayList<>();
        while (resultSet.next()) {
            ingrList.add(
                    Ingredient.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .ingredientName(resultSet.getString(2))
                            .build()
            );
        }

        return ingrList;
    }
}
