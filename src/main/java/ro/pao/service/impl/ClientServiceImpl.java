package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Client;
import ro.pao.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@NoArgsConstructor
@Getter
public class ClientServiceImpl implements ClientService {

    /**
     * Atentie sa fie static. Daca nu o sa fie static, fiecare instanta va avea propria ei lista si astfel vor aparea probleme la apelarea metodelor.
     * Se poate inlocui si cu un Map<UUID, ExampleClass> exampleClassHashMap = new HashMap<>();
     * Si astfel veti avea o performanta la operatii.
     *
     * Puteti folosi diverse structuri de date in functie de nevoi, tinand cont de complexitate.
     */
    private static List<Client> clientList = new ArrayList<>();
    // private static Map<UUID, ExampleClass> exampleClassHashMap = new HashMap<>();

    @Override
    public Optional<Client> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<Client> getAllFromList() {
        return clientList;
    }

    @Override
    public void addAllFromGivenList(List<Client> clientList) {
        ClientServiceImpl.clientList.addAll(clientList);
    }

    @Override
    public void addOnlyOne(Client client) {
        clientList.add(client);
    }

    @Override
    public void removeElementById(UUID id) {
        clientList = clientList.stream()
                .filter(element -> !id.equals(element.getId())) // filtrez elementele astfel incat elementul cautat sa nu fie id-ul dat
                // astfel, o sa avem o lista care nu contine elementul dat
                .collect(Collectors.toList()); // daca folosim .toList() se va crea o lista imutabila.
                // .collect(Collectors.toList()) face o lista mutabila
    }

    @Override
    public void modificaElementById(UUID id, Client newElement) {
        // sterg elementul dat si adaug altul
        removeElementById(id);
        addOnlyOne(newElement);
    }
}
