package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.User;
import ro.pao.service.UserService;

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
public class UserServiceImpl implements UserService {

    /**
     * Atentie sa fie static. Daca nu o sa fie static, fiecare instanta va avea propria ei lista si astfel vor aparea probleme la apelarea metodelor.
     * Se poate inlocui si cu un Map<UUID, ExampleClass> exampleClassHashMap = new HashMap<>();
     * Si astfel veti avea o performanta la operatii.
     *
     * Puteti folosi diverse structuri de date in functie de nevoi, tinand cont de complexitate.
     */
    private static List<User> userList = new ArrayList<>();
    // private static Map<UUID, ExampleClass> exampleClassHashMap = new HashMap<>();

    @Override
    public Optional<User> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<User> getAllFromList() {
        return userList;
    }

    @Override
    public void addAllFromGivenList(List<User> userList) {
        UserServiceImpl.userList.addAll(userList);
    }

    @Override
    public void addOnlyOne(User user) {
        userList.add(user);
    }

    @Override
    public void removeElementById(UUID id) {
        userList = userList.stream()
                .filter(element -> !id.equals(element.getId())) // filtrez elementele astfel incat elementul cautat sa nu fie id-ul dat
                // astfel, o sa avem o lista care nu contine elementul dat
                .collect(Collectors.toList()); // daca folosim .toList() se va crea o lista imutabila.
                // .collect(Collectors.toList()) face o lista mutabila
    }

    @Override
    public void modificaElementById(UUID id, User newElement) {
        // sterg elementul dat si adaug altul
        removeElementById(id);
        addOnlyOne(newElement);
    }
}
