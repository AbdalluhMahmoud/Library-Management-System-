import java.io.*;
import java.util.*;

public class BookFileManager {
    private String fileName;
    
    public BookFileManager(String fileName) {
        this.fileName = fileName;
    }
    
    public List<Book> loadBooks() throws IOException {
        List<String> lines = FileHelper.readFile(fileName);
        List<Book> books = new ArrayList<>();
        for(String line : lines) {
            if(!line.trim().isEmpty()){
                books.add(Book.fromCSV(line));
            }
        }
        return books;
    }
    
    public void saveBooks(List<Book> books) throws IOException {
        List<String> lines = new ArrayList<>();
        for(Book b : books){
            lines.add(b.toCSV());
        }
        FileHelper.writeFile(fileName, lines);
    }
    
    public void addBook(Book b) throws IOException {
        FileHelper.appendLine(fileName, b.toCSV());
    }
    
    public Book findBookById(int id) throws IOException {
        for(Book b : loadBooks()){
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }
    
    public boolean deleteBook(int id) throws IOException {
        List<Book> books = loadBooks();
        boolean removed = books.removeIf(b -> b.getId() == id);
        if(removed){
            saveBooks(books);
        }
        return removed;
    }
    
    public boolean updateBook(Book updatedBook) throws IOException {
        List<Book> books = loadBooks();
        boolean updated = false;
        for(int i=0;i<books.size();i++){
            if(books.get(i).getId() == updatedBook.getId()){
                books.set(i, updatedBook);
                updated = true;
                break;
            }
        }
        if(updated){
            saveBooks(books);
        }
        return updated;
    }
    
    public List<Book> searchBooks(String keyword) throws IOException {
        List<Book> result = new ArrayList<>();
        for(Book b : loadBooks()){
            if(b.getTitle().toLowerCase().contains(keyword.toLowerCase())
               || b.getAuthor().toLowerCase().contains(keyword.toLowerCase())
               || b.getGenre().toLowerCase().contains(keyword.toLowerCase())){
                result.add(b);
            }
        }
        return result;
    }

    
}
