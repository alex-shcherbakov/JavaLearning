package org.example;

import java.util.ArrayList;
import java.util.List;

public class SavedOrders {
    private List<Order> orders;
    public SavedOrders() {
        orders = new ArrayList<>();
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public List<Order> getOrders() {
        return orders;
    }
}
