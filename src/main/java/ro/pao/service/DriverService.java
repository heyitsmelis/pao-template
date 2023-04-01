package ro.pao.service;

import ro.pao.model.Driver;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DriverService {
    Driver newDriver();
    Optional<Driver> getDriverbyId(UUID id);
    List<Driver> showAllDrivers();
    void removeDriver(UUID id);

}
