package ro.pao.service;

import ro.pao.model.Client;
import ro.pao.model.Food;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FoodService {
    Food newFood();
    List<Food> showAllFoods();
    void removeFood(UUID id);
    Optional<Food> getFoodbyId(UUID id);
}
