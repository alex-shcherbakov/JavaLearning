package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order(1, 1);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(1, order.getId());
        assertEquals(1, order.getUserId());

        order.setId(2);
        order.setUserId(3);

        assertEquals(2, order.getId());
        assertEquals(3, order.getUserId());
    }

    @Test
    public void testCalculateTotalPrice() {
        Product product1 = new Product(1, "car",7000.59,4);
        Product product2 = new Product(2, "phone",2300.45,19);

        Map<Product, Integer> orderDetails = new HashMap<>();
        orderDetails.put(product1, 2);
        orderDetails.put(product2, 1);

        order.setOrderDetails(orderDetails);
        order.calculateTotalPrice();

        double expectedTotalPrice = (2 * 7000.59) + 2300.45;
        assertEquals(expectedTotalPrice, order.getTotalPrice());
    }

    @Test
    public void testSetTotalPrice() {
        order.setTotalPrice(1500.50);
        assertEquals(1500.50, order.getTotalPrice());
    }
}

