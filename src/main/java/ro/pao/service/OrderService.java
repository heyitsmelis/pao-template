package ro.pao.service;

import ro.pao.model.Client;
import ro.pao.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    Order newOrder();
    List<Order> showAllOrders();
    void removeOrder(UUID id);
    Optional<Order> getOrderbyId(UUID id);
}
