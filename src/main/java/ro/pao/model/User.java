package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.model.enums.UserType;
import java.util.UUID;

/**
 * Exista @Builder si @SuperBuilder.
 * @SuperBuilder da acces si la campurile la clasa din care se mosteneste.
 * Concret, daca folosim @Builder, o sa avem acces doar la campurile din clasa ExampleClass
 * Iar daca folosim @SuperBuilder o sa avem acces si la campurile din clasa ExampleClass, dar si din clasa AbstractEntity.
 */
@SuperBuilder
@Getter
public class User extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private UUID userId;
    private UserType userType;
}
