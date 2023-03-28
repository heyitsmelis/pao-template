package ro.pao.application;

import ro.pao.model.User;
import ro.pao.service.UserService;
import ro.pao.service.impl.UserServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * In Meniu se fac operatiile care pot lua informatii din toate dintre servicile definite.
 * De exemplu, avem definit mai jos `private final ExampleService exampleService = new ExampleServiceImpl();`
 *
 * In cazul in care aveam definit mai multe servicii, la fel, faceam o initializare a serviciile si astfel apelam metode din serviciu.
 */
public class Menu {

    private static Menu INSTANCE;

    private final UserService userService = new UserServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro() {
        String intro = """
                Intro example
                """;

        System.out.println(intro);

        User user = User.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now()) // data de azi
                .updateDate(LocalDate.now())
                .deleteDate(LocalDate.now())
                .build();

        userService.addOnlyOne(user);

        List<User> exampleServiceList = List.of(
                User.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.of(2023, 03, 22))
                        .updateDate(LocalDate.now())
                        .build(),
                User.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.of(2023, 03, 22))
                        .updateDate(LocalDate.now())
                        .build()
        );

        userService.addAllFromGivenList(exampleServiceList);

        System.out.println("Inainte de stergere: ");
        userService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));


        System.out.println("Dupa modificare: ");
        user.setUpdateDate(LocalDate.of(2, 2, 2));
        userService.modificaElementById(user.getId(), user);
        userService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));

        System.out.println("Dupa stergere: ");
        userService.removeElementById(user.getId());
        userService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));
    }
}
