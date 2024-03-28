package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

    }
    List<Product> searchProductByCategory(List<Product> products, String category) {
         return products.stream()
            .filter(product -> product.getCategory().getCategory().equalsIgnoreCase(category))
            .collect(Collectors.toList());
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
