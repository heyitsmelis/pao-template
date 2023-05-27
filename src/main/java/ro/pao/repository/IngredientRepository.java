package ro.pao.repository;

import ro.pao.model.Ingredient;
import ro.pao.model.Restaurant;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IngredientRepository {

    Optional<Ingredient> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Ingredient newObject);

    void addNewObject(Ingredient ingredient);

    List<Ingredient> getAll();

    void addAllFromGivenList(List<Ingredient> ingredientList);
}
