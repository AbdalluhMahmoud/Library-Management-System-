package com.mycompany.TextFiles;

import com.mycompany.model.Book;
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
    List<Book> allBooks = getAllBooks();
    List<Book> matches = new ArrayList<>();
    
    String search = keyword.toLowerCase(); // Convert input to lowercase

    for (Book b : allBooks) {
        // Checks: Title OR Author OR Genre OR Year OR Status
        if (b.getTitle().toLowerCase().contains(search) || 
            b.getAuthor().toLowerCase().contains(search) ||
            b.getGenre().toLowerCase().contains(search) ||
            String.valueOf(b.getYear()).contains(search) || 
            b.getStatus().toLowerCase().contains(search)) { // <--- ADDED STATUS HERE
            
            matches.add(b);
        }
    }
    return matches;
}

  public List<Book> getAllBooks() {
        try {
            return loadBooks();
        } catch (IOException e) {
            System.err.println("Error reading book file: " + e.getMessage());
            return new ArrayList<>(); // Return empty list on error to prevent crashes
        }
    }
}
