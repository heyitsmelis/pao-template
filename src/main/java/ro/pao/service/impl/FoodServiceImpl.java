package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Client;
import ro.pao.model.Food;
import ro.pao.model.Restaurant;
import ro.pao.model.enums.FoodType;
import ro.pao.model.enums.VehicleType;
import ro.pao.service.FoodService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class FoodServiceImpl implements FoodService {
    private static List<Food> foodList = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);
    @Override
    public Food newFood(){
        Food currentFood = null;

        System.out.println("Denumire mancare:");
        String foodName = scanner.nextLine();

        System.out.println("Pret:");
        Float foodPrice = scanner.nextFloat();

        System.out.println("Nr de kcalorii:");
        Float foodCalories = scanner.nextFloat();

        System.out.println("Tipul de mancare:");
        FoodType foodType = FoodType.getEnumByFieldString(scanner.nextLine());

        System.out.println("Cantitatea:");
        Integer foodQuantity = scanner.nextInt();

        currentFood = new Food(foodName, foodPrice, foodCalories, foodType,foodQuantity);
        foodList.add(currentFood);

        System.out.println("Mancare adaugata cu success!");

        for (Food alim : foodList) {
            System.out.println(alim);
        }
        return currentFood;
    }
}
