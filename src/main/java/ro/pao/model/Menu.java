package ro.pao.model;

import lombok.*;
import ro.pao.model.abstracts.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Menu extends AbstractEntity {

    private List<Food> meniuList;

}
