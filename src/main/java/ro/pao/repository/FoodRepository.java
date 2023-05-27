package ro.pao.repository;

import ro.pao.model.Food;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FoodRepository {

    Optional<Food> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Food newObject);

    void addNewObject(Food food);

    List<Food> getAll();

    void addAllFromGivenList(List<Food> foodList);
}
