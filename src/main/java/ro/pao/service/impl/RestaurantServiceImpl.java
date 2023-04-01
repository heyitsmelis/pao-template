package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Driver;
import ro.pao.model.Food;
import ro.pao.model.Restaurant;
import ro.pao.model.enums.FoodType;
import ro.pao.model.enums.RestaurantType;
import ro.pao.service.RestaurantService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@NoArgsConstructor
@Getter
public class RestaurantServiceImpl implements RestaurantService {
    private static List<Restaurant> shopList = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);

    @Override
    public Restaurant newRestaurant(){
        Restaurant currentShop = null;

        System.out.println("Denumire restaurant:");
        String shopName = scanner.nextLine();

        System.out.println("Adresa:");
        String shopAdress = scanner.nextLine();

        System.out.println("Tipul de restaurant:");
        RestaurantType restaurantType = RestaurantType.getEnumByFieldString(scanner.nextLine());

        currentShop = new Restaurant(shopName, shopAdress, restaurantType);
        shopList.add(currentShop);

        System.out.println("Restaurant creat cu success!");

        for (Restaurant shop :shopList) {
            System.out.println(shop);
        }
        return currentShop;
    }
    @Override
    public List<Restaurant> showAllShops() {
        return shopList;
    }

    @Override
    public void removeShop(UUID id) {
        shopList = shopList.stream()
                .filter(obj -> !id.equals(obj.getId()))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<Restaurant> getShopbyId(UUID id) {
        return Optional.empty();
    }
}
