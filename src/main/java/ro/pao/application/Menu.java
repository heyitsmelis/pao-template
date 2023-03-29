package ro.pao.application;

import ro.pao.model.Client;
import ro.pao.service.ClientService;
import ro.pao.service.impl.ClientServiceImpl;

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

    private final ClientService clientService = new ClientServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro() {
        String intro = """
                Intro example
                """;

        System.out.println(intro);

        Client client = Client.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now()) // data de azi
                .updateDate(LocalDate.now())
                .deleteDate(LocalDate.now())
                .build();

        clientService.addOnlyOne(client);

        List<Client> exampleServiceList = List.of(
                Client.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.of(2023, 03, 22))
                        .updateDate(LocalDate.now())
                        .build(),
                Client.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.of(2023, 03, 22))
                        .updateDate(LocalDate.now())
                        .build()
        );

        clientService.addAllFromGivenList(exampleServiceList);

        System.out.println("Inainte de stergere: ");
        clientService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));


        System.out.println("Dupa modificare: ");
        client.setUpdateDate(LocalDate.of(2, 2, 2));
        clientService.modificaElementById(client.getId(), client);
        clientService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));

        System.out.println("Dupa stergere: ");
        clientService.removeElementById(client.getId());
        clientService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));
    }
}
