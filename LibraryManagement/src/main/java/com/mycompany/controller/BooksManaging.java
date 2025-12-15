/*import com.mycompany.model.Book;
import java.util.ArrayList;

public class BooksManaging {
    private ArrayList<Book> books;

    public BooksManaging() {
        books = new ArrayList<>();
        // Optionally, you can load books from a file here
    }

    // Add a book
    public void addBook(Book b) {
        books.add(b);
        System.out.println("Book added: " + b.getTitle());
    }

    // Search by ISBN
    public Book searchByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) return b;
        }
        return null;
    }

    // Update by ISBN
    public boolean updateBook(String isbn, Book updateBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.set(i, updateBook);
                System.out.println("Book updated: " + updateBook.getTitle());
                return true;
            }
        }
        System.out.println("Book not found.");
        return false;
    }

    // Delete by ISBN
    public boolean deleteBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                System.out.println("Book deleted.");
                return true;
            }
        }
        System.out.println("Book not found.");
        return false;
    }

    // Show all books
    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    // Borrow a book
    public boolean borrowBook(String isbn) {
        Book b = searchByIsbn(isbn);
        if (b != null && b.isAvailable()) {
            b.setAvailable(false);
            System.out.println("Book borrowed: " + b.getTitle());
            return true;
        } else if (b != null) {
            System.out.println("Book is already borrowed.");
        } else {
            System.out.println("Book not found.");
        }
        return false;
    }

    // Return a book
    public boolean returnBook(String isbn) {
        Book b = searchByIsbn(isbn);
        if (b != null && !b.isAvailable()) {
            b.setAvailable(true);
            System.out.println("Book returned: " + b.getTitle());
            return true;
        } else if (b != null) {
            System.out.println("Book was not borrowed.");
        } else {
            System.out.println("Book not found.");
        }
        return false;
    }
}
*/