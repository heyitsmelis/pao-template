package ro.pao.service;

import ro.pao.model.Client;
import ro.pao.model.Ingredient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IngredientService {
    Ingredient newIngr();
    List<Ingredient> showAllIngrs();
    void removeIngredient(UUID id);
    Optional<Ingredient> getIngrbyId(UUID id);
}
