package ro.pao.repository;

import ro.pao.model.Driver;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DriverRepository {

    Optional<Driver> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Driver newObject);

    void addNewObject(Driver driver);

    List<Driver> getAll();

    void addAllFromGivenList(List<Driver> restaurantList);
}
