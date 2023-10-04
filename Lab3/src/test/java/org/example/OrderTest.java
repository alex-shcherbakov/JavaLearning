package org.example;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class OrderTest {
    public Product product1;
    public Product product2;
    public Cart cart;
    public Order order;
    @BeforeEach
    public void setup() {
        product1 = new Product(1, "Product 1", 19.99);
        product2 = new Product(2, "Product 2", 29.99);
        cart = mock(Cart.class);
        order = mock(Order.class);
    }
    @Test
    public void testPlaceOrder() {
        when(cart.getProducts()).thenReturn(new ArrayList<>());
        when(order.getStatus()).thenReturn("Awaiting");

        order = new Order(1, cart.getProducts());

        assertEquals("Awaiting", order.getStatus());
    }


    @Test
    public void testGetOrderStatus() {
        when(order.getStatus()).thenReturn("Awaiting");

        assertEquals("Awaiting", order.getStatus());

        when(order.getStatus()).thenReturn("Shipped");
        assertEquals("Shipped", order.getStatus());
    }


}