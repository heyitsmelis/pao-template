package ro.pao.application;

import ro.pao.model.Client;
import ro.pao.service.ClientService;
import ro.pao.service.impl.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
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

    private ClientServiceImpl clientImpl = new  ClientServiceImpl();
    private DriverServiceImpl driverImpl = new DriverServiceImpl();
    private FoodServiceImpl foodImpl = new FoodServiceImpl();
    private IngredientServiceImpl ingrImpl = new IngredientServiceImpl();
    private OrderServiceImpl orderImpl = new OrderServiceImpl();
    private RestaurantServiceImpl shopImpl = new RestaurantServiceImpl();

    public Scanner scanner = new Scanner(System.in);

    public void intro() {
        String intro = """
                Bine ati venit pe platforma "FoodKoala"! Cu ce va putem ajuta?
                WIP
                """;

        System.out.println(intro);
        System.out.println("1) Creeaza un cont nou");
        System.out.println("2) Adauga un sofer nou");
        System.out.println("3) Adauga un restaurant nou");
        System.out.println("4) Adauga o mancare noua");
        System.out.println("5) Adauga un ingredient nou");
        System.out.println("6) Efectueaza o comanda");
        System.out.println("7) Exit");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                clientImpl.newClient();
                break;
            case 2:
                driverImpl.newDriver();
                break;
            case 3:
                shopImpl.newRestaurant();
                break;
            case 4:
                foodImpl.newFood();
                break;
            case 5:
                ingrImpl.newIngr();
                break;
            case 6:
                orderImpl.newOrder();
                break;

            case 7:
                System.out.println("Va mai asteptam pe la noi :)");
                break;

            default:
                System.out.println("Invalid option! :(");

        //Client client = Client.builder()
                //.id(UUID.randomUUID())
                //.creationDate(LocalDate.now()) // data de azi
                //.updateDate(LocalDate.now())
                //.deleteDate(LocalDate.now())
               // .build();

        //clientService.addOnlyOne(client);

        //List<Client> exampleServiceList = List.of(
                //Client.builder()
                        //.id(UUID.randomUUID())
                       // .creationDate(LocalDate.of(2023, 03, 22))
                       // .updateDate(LocalDate.now())
                       // .build(),
               // Client.builder()
                      //  .id(UUID.randomUUID())
                       // .creationDate(LocalDate.of(2023, 03, 22))
                      //  .updateDate(LocalDate.now())
                       // .build()
        //);

        //clientService.addAllFromGivenList(exampleServiceList);

//        System.out.println("Inainte de stergere: ");
//        clientService.getAllFromList()
//                .forEach(elementFromList -> System.out.println(elementFromList));
//
//
//        System.out.println("Dupa modificare: ");
//       // client.//setUpdateDate(LocalDate.of(2, 2, 2));
//        //clientService.modificaElementById(client.getId(), client);
//        //clientService.getAllFromList()
//               // .forEach(elementFromList -> System.out.println(elementFromList));
//
//        System.out.println("Dupa stergere: ");
//        clientService.removeElementById(client.getId());
//        clientService.getAllFromList()
//                .forEach(elementFromList -> System.out.println(elementFromList));
    }
}}
