package ro.pao.model;

import lombok.*;
import ro.pao.model.abstracts.AbstractEntity;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Ingredient extends AbstractEntity {
    private UUID id;
    private String ingredientName;

    public String getIngredientStringField() {
        return null;
    }
}
