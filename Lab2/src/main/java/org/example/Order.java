package org.example;
import java.util.List;

public class Order {
    public int orderId;
    public List<Product> products;
    public String status;

    public Order(int orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.status = "Awaiting";
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
