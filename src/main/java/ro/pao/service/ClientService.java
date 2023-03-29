package ro.pao.service;

import ro.pao.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'ExampleClass' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'ExampleClass'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface ClientService {

    Optional<Client> getById(UUID id);

    Optional<Client> getBySomeFieldOfClass(Object someFieldFromUser);

    List<Client> getAllFromList();

    void addAllFromGivenList(List<Client> clientList);

    void addOnlyOne(Client client);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Client newElement);
}