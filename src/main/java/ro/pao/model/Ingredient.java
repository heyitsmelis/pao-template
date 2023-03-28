package ro.pao.model;

import lombok.*;
import ro.pao.model.abstracts.AbstractEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Ingredient extends AbstractEntity {
    private String ingredientName;

}
