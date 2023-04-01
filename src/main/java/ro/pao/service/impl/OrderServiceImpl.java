package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.*;
import ro.pao.model.enums.FoodType;
import ro.pao.model.enums.OrderType;
import ro.pao.service.OrderService;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class OrderServiceImpl implements OrderService {
    private static List<Order> orderList = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);
    @Override
    public Order newOrder(){
        Order currentOrder = null;
        System.out.println("Clientul care plaseaza comanda:");
        String userName = scanner.nextLine();

        System.out.println("Numele restaurantului la care se plaseaza comanda:");
        String restaurantName = scanner.nextLine();

        System.out.println("Mancarea Comandata:");
        String foodName = scanner.nextLine();

        System.out.println("Tipul de comanda:");
        OrderType orderType = OrderType.getEnumByFieldString(scanner.nextLine());

        currentOrder = new Order(userName, restaurantName, foodName, orderType);
        orderList.add(currentOrder);

        System.out.println("Client creat cu success!");

        for (Order comanda : orderList) {
            System.out.println(comanda);
        }
        return currentOrder;
    }
    @Override
    public List<Order> showAllOrders() {
        return orderList;
    }

    @Override
    public void removeOrder(UUID id) {
        orderList = orderList.stream()
                .filter(obj -> !id.equals(obj.getId()))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<Order> getOrderbyId(UUID id) {
        return Optional.empty();
    }
}

