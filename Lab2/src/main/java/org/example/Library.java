package org.example;
import java.util.ArrayList;
import java.util.List;

    public class Library implements IManageable {
    public List<Item> items;
    public List<Patron> patrons;

    public Library() {
        this.items = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public void listAvailable() {
        System.out.println("Available items in the library:");
        for (Item item : items) {
            if (!item.isBorrowed()) {
                System.out.println(item.getTitle());
            }
        }
    }

    @Override
    public void listBorrowed() {
        System.out.println("Borrowed items from the library:");
        for (Item item : items) {
            if (item.isBorrowed()) {
                System.out.println(item.getTitle());
            }
        }
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (patrons.contains(patron) && items.contains(item) && !item.isBorrowed()) {
            patron.borrow(item);
            item.borrowItem();
            System.out.println("Item '" + item.getTitle() + "' has been lent to patron " + patron.getName());
        } else {
            System.out.println("Item cannot be lent to the patron.");
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (patrons.contains(patron) && items.contains(item) && item.isBorrowed() && patron.getBorrowedItems().contains(item)) {
            patron.returnItem(item);
            item.returnItem();
            System.out.println("Item '" + item.getTitle() + "' has been returned by patron " + patron.getName());
        } else {
            System.out.println("Item cannot be returned by the patron.");
        }
    }
}
