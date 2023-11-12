package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ECommercePlatformTest {
    private ECommercePlatform eCommercePlatform;
    @BeforeEach
    public void setUp() {
        eCommercePlatform = new ECommercePlatform();
    }

    @Test
    public void testAddUser() {
        User user = new User(1, "john_doe");
        eCommercePlatform.addUser(user);

        assertTrue(eCommercePlatform.users.containsKey(user.getId()));
    }

    @Test
    public void testAddProduct() {
        Product product = new Product(1, "car", 100.59, 99);
        eCommercePlatform.addProduct(product);

        assertTrue(eCommercePlatform.products.containsKey(product.getId()));
    }

    @Test
    public void testCreateOrder() {
        User user = new User(1, "john_doe");
        Product product = new Product(2, "laptop" , 3500.57,76);

        eCommercePlatform.addUser(user);
        eCommercePlatform.addProduct(product);

        Map<Product, Integer> orderDetails = new HashMap<>();
        orderDetails.put(product, 2);

        Order order = new Order(1, user.getId());
        order.setOrderDetails(orderDetails);

        eCommercePlatform.createOrder(order);

        assertTrue(eCommercePlatform.orders.containsKey(order.getId()));
    }

    @Test
    public void testUpdateProductStock() {
        Product product = new Product(3, "something", 15.67,99);
        eCommercePlatform.addProduct(product);

        eCommercePlatform.updateProductStock(product, 10);

        assertEquals(10, product.getStock());
    }


    @Test
    public void testGetRecommendations() {
        User user = new User(1, "john_doe");
        Product product1 = new Product(1, "car",2500.39,3);
        Product product2 = new Product(2, "car",2600.39,6);

        eCommercePlatform.addUser(user);
        eCommercePlatform.addProduct(product1);
        eCommercePlatform.addProduct(product2);

        user.addToCart(product1, 1);

        List<Product> recommendations = eCommercePlatform.getRecommendations(user);

        assertTrue(recommendations.contains(product2));
    }
}