package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(1, "John");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(1, user.getId());
        assertEquals("John", user.getUsername());

        user.setId(2);
        user.setUsername("new_user");

        assertEquals(2, user.getId());
        assertEquals("new_user", user.getUsername());
    }

    @Test
    public void testAddToCart() {
        Product product1 = new Product(6, "ship", 5000.99,1);
        Product product2 = new Product(7, "car",2500.00,5);

        user.addToCart(product1, 2);
        user.addToCart(product2, 1);

        Map<Product, Integer> expectedCart = new HashMap<>();
        expectedCart.put(product1, 2);
        expectedCart.put(product2, 1);

        assertEquals(expectedCart, user.getCart());
    }

    @Test
    public void testRemoveInCart() {
        Product product = new Product(1 , "knife", 15.00, 5);

        user.addToCart(product, 3);
        user.removeInCart(product);

        assertTrue(user.getCart().isEmpty());
    }

    @Test
    public void testUpdateCart() {
        Product product = new Product(2, "something", 135.45, 19);

        user.addToCart(product, 3);
        user.updateCart(product, 5);

        Map<Product, Integer> expectedCart = new HashMap<>();
        expectedCart.put(product, 5);

        assertEquals(expectedCart, user.getCart());
    }

    @Test
    public void testUpdateCartNonExistingProduct() {
        Product product = new Product(5, "shoes",215.97,25);

        user.updateCart(product, 5);

        assertTrue(user.getCart().isEmpty());
    }
}


