package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Client;
import ro.pao.model.Driver;
import ro.pao.model.Restaurant;
import ro.pao.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Scanner;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@NoArgsConstructor
@Getter
public class ClientServiceImpl implements ClientService {
    private static List<Client> clientList = new ArrayList<>();

    public Scanner scanner = new Scanner(System.in);
    @Override
    public Client newClient(){
        Client currentClient = null;

        UUID id = UUID.randomUUID();

        System.out.println("Prenume:");
        String firstName = scanner.nextLine();

        System.out.println("Nume:");
        String lastName = scanner.nextLine();

        System.out.println("Nume de utilizator:");
        String userName = scanner.nextLine();



        currentClient = new Client(id, firstName, lastName, userName);
        clientList.add(currentClient);

        System.out.println("Client creat cu success!");

        for (Client person : clientList) {
            System.out.println(person);
        }
        return currentClient;
    }
    @Override
    public List<Client> showAllClients() {
        return clientList;
    }

    @Override
    public void removeClient(UUID id) {
        clientList = clientList.stream()
                .filter(obj -> !id.equals(obj.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> getClientbyId(UUID id) {
        return Optional.empty();
    }
}

