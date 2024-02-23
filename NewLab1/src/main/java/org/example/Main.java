package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        List<Product> products = new ArrayList<>();
        SavedOrders orderHistory = new SavedOrders();

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1 - Create a product");
            System.out.println("2 - View the list of products");
            System.out.println("3 - Add product to cart");
            System.out.println("4 - view cart");
            System.out.println("5 - Delete product from cart");
            System.out.println("6 - Create Order");
            System.out.println("7 - Search for product");
            System.out.println("8 - History of created orders");
            System.out.println("0 - Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter information about the new product:");
                    System.out.print("Id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Description: ");
                    String descr = scanner.nextLine();
                    System.out.print("Category: ");
                    String category = scanner.nextLine();

                    Category productCategory = new Category(category);
                    Product newProduct = new Product(id, name, price, descr, productCategory);
                    products.add(newProduct);

                    break;
                case 2:
                    System.out.println("List of products:");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 3:
                    System.out.println("List of products:");
                    for (Product product : products) {
                        System.out.println("Id: " + product.getId() + ", Name: " + product.getName());
                    }
                    System.out.print("Enter the product ID to add to cart: ");
                    int productId = scanner.nextInt();
                    boolean found = false;

                    for (Product product : products) {
                        if (product.getId() == productId) {
                            cart.addProduct(product);
                            System.out.println("The product has been added to the cart.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Product with the provided ID does not exist.");
                    }
                    break;
                case 4:
                    List<Product> cartProducts = cart.getProducts();
                    if (cartProducts.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        System.out.println("Cart:");
                        for (Product product : cartProducts) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 5:
                    System.out.println("List of products in the basket:");
                    List<Product> cartProductsList = cart.getProducts();
                    for (Product product : cartProductsList) {
                        System.out.println("Id: " + product.getId() + ", Name: " + product.getName());
                    }
                    System.out.print("Enter Id to delete from cart: ");
                    int removeProductId = scanner.nextInt();
                    boolean removed = false;
                    for (Product product : cartProductsList) {
                        if (product.getId() == removeProductId) {
                            cart.removeProduct(product);
                            System.out.println("Product removed from the cart.");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Product with such Id was not found in the cart.");
                    }
                    break;
                case 6:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Cart is empty. There is nothing to order.");
                    } else {
                        Order order = new Order(cart);
                        orderHistory.addOrder(order);
                        System.out.println("Order №" + order.getOrderId() + " is created. Status: " + order.getStatus());
                        cart.getProducts().clear();
                    }
                    break;
                case 7:
                    System.out.println("Select a search option:");
                    System.out.println("1 - Search by name");
                    System.out.println("2 - Search by category");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (searchChoice) {
                        case 1:
                            System.out.print("Enter the product name to search: ");
                            String searchName = scanner.nextLine();
                            List<Product> foundByName = cart.searchProductByName(products, searchName);
                            cart.displaySearchResults(foundByName);
                            break;
                        case 2:
                            System.out.print("Enter the product category to search: ");
                            String searchCategory = scanner.nextLine();
                            List<Product> foundByCategory = cart.searchProductByCategory(products, searchCategory);
                            cart.displaySearchResults(foundByCategory);
                            break;
                        default:
                            System.out.println("Incorrect selection entered.");
                            break;
                    }
                    break;
                case 8:
                    List<Order> orderList = orderHistory.getOrders();
                    if (orderList.isEmpty()) {
                        System.out.println("The order history is empty.");
                    } else {
                        System.out.println("List of saved orders:");
                        for (Order order : orderList) {
                            System.out.println("Order №" + order.getOrderId());
                            System.out.println("Status: " + order.getStatus());
                            System.out.println("Products:");
                            for (Product product : order.getProducts()) {
                                System.out.println("Name: " + product.getName());
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Incorrect selection entered. Try again.");
                    break;
            }
        }
    }
}