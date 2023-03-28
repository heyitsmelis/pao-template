package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Restaurant;
import ro.pao.service.RestaurantService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@NoArgsConstructor
@Getter
public class RestaurantServiceImpl implements RestaurantService {

    /**
     * Atentie sa fie static. Daca nu o sa fie static, fiecare instanta va avea propria ei lista si astfel vor aparea probleme la apelarea metodelor.
     * Se poate inlocui si cu un Map<UUID, ExampleClass> exampleClassHashMap = new HashMap<>();
     * Si astfel veti avea o performanta la operatii.
     *
     * Puteti folosi diverse structuri de date in functie de nevoi, tinand cont de complexitate.
     */
    private static List<Restaurant> shopList = new ArrayList<>();
    // private static Map<UUID, ExampleClass> exampleClassHashMap = new HashMap<>();

    @Override
    public Optional<Restaurant> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Restaurant> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<Restaurant> getAllFromList() {
        return shopList;
    }

    @Override
    public void addAllFromGivenList(List<Restaurant> shopList) {
        RestaurantServiceImpl.shopList.addAll(shopList);
    }

    @Override
    public void addOnlyOne(Restaurant restaurant) {
        shopList.add(restaurant);
    }

    @Override
    public void removeElementById(UUID id) {
        shopList = shopList.stream()
                .filter(element -> !id.equals(element.getId())) // filtrez elementele astfel incat elementul cautat sa nu fie id-ul dat
                // astfel, o sa avem o lista care nu contine elementul dat
                .collect(Collectors.toList()); // daca folosim .toList() se va crea o lista imutabila.
        // .collect(Collectors.toList()) face o lista mutabila
    }

    @Override
    public void modificaElementById(UUID id, Restaurant newElement) {
        // sterg elementul dat si adaug altul
        removeElementById(id);
        addOnlyOne(newElement);
    }
}