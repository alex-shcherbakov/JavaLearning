package org.example;

import java.util.HashMap;
import java.util.Map;

public class Order {
    int id ;
    int userId ;
    Map<Product, Integer> orderDetails ;
    double totalPrice ;
    public Order(int id,int userId){
        this.id =id;
        this.userId = userId;
        this.orderDetails = new HashMap<>();
        this.totalPrice = 0;
    }
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public Map<Product, Integer> getOrderDetails(){
        return orderDetails;
    }
    public void setOrderDetails(Map<Product, Integer> orderDetails){
        this.orderDetails = orderDetails;
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    public void calculateTotalPrice() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : orderDetails.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        this.totalPrice = total;
    }
}
