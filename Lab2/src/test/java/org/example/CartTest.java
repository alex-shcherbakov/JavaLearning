package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CartTest {
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
    public void testAddProductToCart() {
        when(cart.getProducts()).thenReturn(new ArrayList<>());
        cart.addProduct(product1);
        List<Product> cartProducts = cart.getProducts();
        assertEquals(1, cartProducts.size());
        assertEquals(product1, cartProducts.get(0));
    }

    @Test
    public void testRemoveProductFromCart() {
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        when(cart.getProducts()).thenReturn(products);

        cart.removeProduct(product1);

        List<Product> cartProducts = cart.getProducts();
        assertEquals(1, cartProducts.size());
        assertEquals(product2, cartProducts.get(0));
    }

}