package org.example;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("1984", "1234", "Orwell");
        Book book2 = new Book("Physics", "ASD0F", "John");
        DVD dvd1 = new DVD("DVD 1", "KT11", 135);
        DVD dvd2 = new DVD("DVD 2","QWERTY",900);

        library.add(book1);
        library.add(book2);
        library.add(dvd1);
        library.add(dvd2);

        Patron patron1 = new Patron("Patron 1", "P001");
        Patron patron2 = new Patron("Patron 2", "P002");

        library.registerPatron(patron1);
        library.registerPatron(patron2);

        library.lendItem(patron1, book1);
        library.lendItem(patron1, book2);
        library.lendItem(patron2, dvd2);

        library.returnItem(patron1,book2);

        library.listAvailable();
        library.listBorrowed();

        dvd2.setDuration(350);
        System.out.print("dvd2's duration is " + dvd2.getDuration());
        System.out.print("dvd2's ID is " + dvd2.getUniqueID());
        library.remove(dvd2);
    }
}