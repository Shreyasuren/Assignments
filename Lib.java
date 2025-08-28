class Book {
    String title;
    String author;
    boolean available = true;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    void returnBook() {
        if (!available) {
            available = true;
            System.out.println(title + " has been returned and is now available.");
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }
}

class Library {
    Book[] books;

    Library(Book[] books) {
        this.books = books;
    }

    void returnBook(String bookTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(bookTitle)) {
                book.returnBook();  // calls Book’s returnBook method
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }
}

public class Lib {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James");
        Book b2 = new Book("OOP Concepts", "Smith");

        Library lib = new Library(new Book[]{b1, b2});

        b1.borrowBook();
        lib.returnBook("Java Basics");
        lib.returnBook("OOP Concepts");
    }
}