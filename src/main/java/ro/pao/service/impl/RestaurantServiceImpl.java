package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Restaurant;
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
}