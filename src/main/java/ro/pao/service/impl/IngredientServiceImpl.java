package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Food;
import ro.pao.model.Ingredient;
import ro.pao.model.Restaurant;
import ro.pao.model.enums.FoodType;
import ro.pao.model.enums.VehicleType;
import ro.pao.service.IngredientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
@Getter
public class IngredientServiceImpl implements IngredientService {
    private static List<Ingredient> ingredientList = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);

    @Override
    public Ingredient newIngr(){
        Ingredient currentIngr = null;

        System.out.println("Denumire ingredient:");
        String ingredientName = scanner.nextLine();

        currentIngr = new Ingredient(ingredientName);
        ingredientList.add(currentIngr);

        System.out.println("Ingredient adaugat cu success!");

        for (Ingredient ingr : ingredientList) {
            System.out.println(ingr);
        }
        return currentIngr;
    }
}
