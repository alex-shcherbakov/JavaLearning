package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int lastOrderId = 0;
    private List<Product> products;
    private int orderId;
    private String status;
    public Order(Cart cart) {
        this.products = new ArrayList<>(cart.getProducts());
        this.orderId = ++lastOrderId;
        this.status = "Being processed";
    }
    public List<Product> getProducts() {
        return products;
    }
    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
