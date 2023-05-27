package ro.pao.repository;

import ro.pao.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    Optional<Order> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void AddDriverById(UUID id, Order newObject);

    void addNewObject(Order order);

    List<Order> getAll();

    void addAllFromGivenList(List<Order> orderList);
}
