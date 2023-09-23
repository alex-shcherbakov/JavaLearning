import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < number; i++) {
            System.out.print("Enter title of book: ");
            String title = scanner.nextLine();
            System.out.print("Enter the author of the book: ");
            String author = scanner.nextLine();
            System.out.print("Enter book ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Enter the year the book was published: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            Book book1 = new Book(title, author, isbn, year);
            library.addBook(book1);

        }

        library.showAllBooks();

        System.out.print("Enter the title of the book you want to find : ");
        String searchTitle = scanner.nextLine();
        Book foundBook = library.findBookByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Found book: " + foundBook.getTitle());
        } else {
            System.out.println("book with a title \"" + searchTitle + "\" wasn't found.");
        }

        System.out.print("Enter the IBS you want to delete : ");
        String IsbnToRemove = scanner.nextLine();
        library.removeBookByIsbn(IsbnToRemove);


        library.showAllBooks();
    }
}