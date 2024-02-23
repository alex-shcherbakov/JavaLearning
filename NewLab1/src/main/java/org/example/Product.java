package org.example;

public class Product {
    private int id;
    private String name;
    private double price;
    private String descr;
    private Category category;
    public Product(int id, String name, double price, String descr, Category category){
        this.id = id;
        this.name = name;
        this.price = price;
        this.descr = descr;
        this.category = category;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getDescr(){
        return descr;
    }
    public Category getCategory() {
        return category;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Name: " + name + "\n" +
                "Price: " + price + "\n" +
                "Description: " + descr + "\n" +
                "Category: " + category.getCategory();
    }
}
