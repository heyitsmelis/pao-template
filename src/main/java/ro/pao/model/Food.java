package ro.pao.model;

import lombok.*;
import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.model.enums.FoodType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Food extends AbstractEntity {
    private String foodName;

    private Float foodPrice;

    private Float foodCalories;

    private FoodType foodType;

    private Integer foodQuantity;

    private List<Ingredient> ingrList;

    public Food(String foodName, Float foodPrice, Float foodCalories, FoodType foodType, Integer foodQuantity) {

    }
}
