package org.example;
import java.util.HashMap;
import java.util.Map;

public class User {
    int id ;
    String username ;
    Map<Product, Integer> cart ;
    public User(int id,String username){
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id =id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public Map<Product, Integer> getCart() {
        return cart;
    }
    public void setCart(Map<Product, Integer> cart){
        this.cart = cart;
    }

    public void addToCart(Product product, int number) {
        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + number);
        } else {
            cart.put(product, number);
        }
    }

    public void removeInCart(Product product) {
        cart.remove(product);
    }

    public void updateCart(Product product, int newNumber) {
        if (cart.containsKey(product)) {
            cart.put(product, newNumber);
        }
    }
}
