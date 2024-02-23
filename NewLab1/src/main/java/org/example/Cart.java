package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(Product product) {
        products.remove(product);
    }
    public List<Product> getProducts() {
        return products;
    }
    List<Product> searchProductByName(List<Product> products, String name) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }
    List<Product> searchProductByCategory(List<Product> products, String category) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().getCategory().equalsIgnoreCase(category)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }
    void displaySearchResults(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products were found according to the specified criteria.");
        } else {
            System.out.println("Search Results:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
