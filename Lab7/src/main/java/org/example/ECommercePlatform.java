package org.example;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class ECommercePlatform {
    Map<Integer, User> users ;
    Map<Integer, Product> products ;
    Map<Integer, Order> orders ;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }
    public void addUser(User user) {
        users.put(user.getId(), user);
    }
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }
    public void createOrder(Order order) {
        order.calculateTotalPrice();
        orders.put(order.getId(), order);
    }
    public void listAvailableProducts() {
        System.out.println("Available products:");
        for (Product product : products.values()) {
            System.out.println(product.getName() + " - " + product.getStock());
        }
    }
    public void listUsers() {
        System.out.println("Users:");
        for (User user : users.values()) {
            System.out.println("ID: " + user.getId() + ", User's name: " + user.getUsername());
        }
    }
    public void listOrders() {
        System.out.println("Order:");
        for (Order order : orders.values()) {
            System.out.println("Order #" + order.getId() +
                    " for user #" + order.getUserId() +
                    " with cost " + order.getTotalPrice() + " USD.");
        }
    }
    public void updateProductStock(Product product, int newStock) {
        if (products.containsKey(product.getId())) {
            product.setStock(newStock);
        }
    }

    public void displayProductsSortedByName() {
        List<Product> sortedProducts = new ArrayList<>(products.values());
        Collections.sort(sortedProducts, Comparator.comparing(Product::getName));
        System.out.println("List of products sorted by name:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }
    public void displayProductsSortedByPrice() {
        List<Product> sortedProducts = new ArrayList<>(products.values());
        Collections.sort(sortedProducts);
        System.out.println("List of products sorted by price:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }
    public void displayProductsSortedByStock() {
        List<Product> sortedProducts = new ArrayList<>(products.values());
        Collections.sort(sortedProducts, Comparator.comparingInt(Product::getStock));
        System.out.println("List of products sorted by stock:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }
    public void filterProductsByStock(int minStock) {
        System.out.println("There are more products in stock than" + minStock + ":");
        for (Product product : products.values()) {
            if (product.getStock() > minStock) {
                System.out.println(product);
            }
        }
    }

    public List<Product> getRecommendations(User user) {
        List<Product> recommendations = new ArrayList<>();

        Map<Product, Integer> userCart = user.getCart();
        for (Product product : userCart.keySet()) {
            List<Product> similarProducts = findSimilarProducts(product);
            recommendations.addAll(similarProducts);
        }

        List<Order> userOrders = findUserOrders(user);
        for (Order order : userOrders) {
            Map<Product, Integer> orderDetails = order.getOrderDetails();
            for (Product product : orderDetails.keySet()) {
                List<Product> purchasedProducts = findPurchasedProducts(product);
                recommendations.addAll(purchasedProducts);
            }
        }

        Set<Product> uniqueRecommendations = new HashSet<>(recommendations);
        recommendations.clear();
        recommendations.addAll(uniqueRecommendations);

        return recommendations;
    }

    private List<Product> findSimilarProducts(Product targetProduct) {
        List<Product> similarProducts = new ArrayList<>();
        for (Product product : products.values()) {
            if (!product.equals(targetProduct) && product.getName().equals(targetProduct.getName())) {
                similarProducts.add(product);
            }
        }
        return similarProducts;
    }

    private List<Product> findPurchasedProducts(Product targetProduct) {
        List<Product> purchasedProducts = new ArrayList<>();
        for (Order order : orders.values()) {
            Map<Product, Integer> orderDetails = order.getOrderDetails();
            if (orderDetails.containsKey(targetProduct)) {
                purchasedProducts.add(targetProduct);
            }
        }
        return purchasedProducts;
    }

    private List<Order> findUserOrders(User user) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getUserId() == user.getId()) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }
}
