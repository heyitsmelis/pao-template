package ro.pao.service;

import ro.pao.model.Client;
import ro.pao.model.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface RestaurantService {
    Restaurant newRestaurant();
    List<Restaurant> showAllShops();
    void removeShop(UUID id);
    Optional<Restaurant> getShopbyId(UUID id);
}
