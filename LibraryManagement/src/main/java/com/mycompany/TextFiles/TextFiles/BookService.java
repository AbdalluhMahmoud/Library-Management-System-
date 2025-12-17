import java.io.*;
import java.util.*;

public class BookService {

    private BookFileManager manager;

    public BookService(String fileName) {
        this.manager = new BookFileManager(fileName);
    }

    private int generateNewId() throws IOException {
        List<Book> books = manager.loadBooks();
        int max = 0;
        for(Book b : books){
            if(b.getId() > max) max = b.getId();
        }
        return max + 1;
    }

    public void addBook(String title, String author, String genre, int year) throws IOException {
        int id = generateNewId();
        Book newBook = new Book(id, title, author, genre, year, "AVAILABLE");
        manager.addBook(newBook);
    }

    public boolean updateBook(Book updatedBook) throws IOException {
        return manager.updateBook(updatedBook);
    }

    public boolean deleteBook(int id) throws IOException {
        return manager.deleteBook(id);
    }

    public List<Book> getAllBooks() throws IOException {
        return manager.loadBooks();
    }

    public List<Book> searchBooks(String keyword) throws IOException {
        return manager.searchBooks(keyword);
    }
}

