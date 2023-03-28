package ro.pao.service;

import ro.pao.model.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface RestaurantService {
    Optional<Restaurant> getById(UUID id);

    Optional<Restaurant> getBySomeFieldOfClass(Object someFieldFromRestaurant);

    List<Restaurant> getAllFromList();

    void addAllFromGivenList(List<Restaurant> RestaurantList);

    void addOnlyOne(Restaurant restaurant);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Restaurant newElement);
}
