package org.example;


public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Product 1", 50.99);
        Product product2 = new Product(2, "Product 2", 100.00);

        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);

        Order order = new Order(1, cart.getProducts());

        order.setStatus("Shipped");

        String orderStatus = order.getStatus();
        int OrderId = order.getOrderId();
        System.out.println("Order status: " + orderStatus +"OrderId:" +OrderId);
        String prod = product1.getName();
        System.out.println("Info about product: " + prod);

        cart.clearCart();

    }
}