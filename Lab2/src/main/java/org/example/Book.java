package org.example;

public class Book extends Item {
    private String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void borrowItem() {
        if (!isBorrowed()) {
            setBorrowed(true);
            System.out.println("Book '" + getTitle() + "' has been borrowed.");
        } else {
            System.out.println("Book '" + getTitle() + "' is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed()) {
            setBorrowed(false);
            System.out.println("Book '" + getTitle() + "' has been returned.");
        } else {
            System.out.println("Book '" + getTitle() + "' is not currently borrowed.");
        }
    }
}
