package org.example;
import java.util.List;

public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(1, "John");
        User user2 = new User(2, "Ann");
        platform.addUser(user1);
        platform.addUser(user2);


        Product pen = new Product(1, "pen", 1.39, 100);
        Product car = new Product(2, "car", 2500.99, 3);
        platform.addProduct(pen);
        platform.addProduct(car);

        user1.addToCart(pen, 9);
        user2.addToCart(car, 1);

        Order order1 = new Order(1,
                user1.getId());
        order1.setOrderDetails(user1.getCart());
        platform.createOrder(order1);
        Order order2 = new Order(2,
                user2.getId());
        order2.setOrderDetails(user2.getCart());
        platform.createOrder(order2);
        System.out.println("The state of the platform after creating orders:");
        platform.listOrders();


        List<Product> recommendationsUser1 = platform.getRecommendations(user1);
        List<Product> recommendationsUser2 = platform.getRecommendations(user2);

        System.out.println("\nRecommendations for the user " + user1.getUsername() + ":");
        for (Product recommendation : recommendationsUser1) {
            System.out.println(recommendation);
        }

        System.out.println("\nRecommendations for the user " + user2.getUsername() + ":");
        for (Product recommendation : recommendationsUser2) {
            System.out.println(recommendation);
        }

        platform.updateProductStock(pen, 8);
        platform.updateProductStock(car, 12);

        System.out.println("\nPlatform status after updates and recommendations:");
        platform.listAvailableProducts();
        platform.listOrders();



        platform.listOrders();
        platform.listUsers();

        platform.updateProductStock(pen, 50);
        platform.updateProductStock(car, 3);

        platform.listAvailableProducts();
        platform.displayProductsSortedByName();
        platform.displayProductsSortedByPrice();
        platform.displayProductsSortedByStock();
        platform.filterProductsByStock(5);
    }
}
