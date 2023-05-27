package ro.pao.repository;

import ro.pao.model.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepository {

    Optional<Restaurant> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Restaurant newObject);

    void addNewObject(Restaurant exampleClass);

    List<Restaurant> getAll();

    void addAllFromGivenList(List<Restaurant> exampleClassList);
}