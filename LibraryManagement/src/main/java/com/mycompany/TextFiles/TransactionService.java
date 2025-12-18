package com.mycompany.TextFiles;

import com.mycompany.model.Transaction;
import com.mycompany.model.Book;
import java.io.*;
import java.util.*;

public class TransactionService {
    private TransactionFileManager transactionManager;
    private BookService bookService;
    
    public TransactionService(String transactionFile, String bookFile){
        this.transactionManager = new TransactionFileManager(transactionFile);
        this.bookService = new BookService(bookFile);
    }
    
    private int generateNewId() throws IOException{
        List<Transaction> list = transactionManager.loadTransactions();
        int max = 0;
        for(Transaction t : list){
            if(t.getTransactionId() > max) max = t.getTransactionId();
        }
        return max + 1;
    }
    
    public Book getBookById(int id) throws IOException {
        List<Book> books = bookService.getAllBooks();
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null; 
    }

    public void updateBook(Book updatedBook) throws IOException {
        bookService.updateBook(updatedBook);
    }

    public boolean issueBook(int userId, int bookId) throws IOException {
        Book book = getBookById(bookId);

        if (book == null || !book.getStatus().equalsIgnoreCase("AVAILABLE")) {
            return false; 
        }

        int transactionId = (int) (System.currentTimeMillis() / 1000); 
        String borrowDate = java.time.LocalDate.now().toString();
        String dueDate = java.time.LocalDate.now().plusDays(14).toString(); 

        Transaction t = new Transaction(transactionId, userId, bookId, borrowDate, dueDate, null, "BORROWED");
        transactionManager.addTransaction(t);

        book.setStatus("BORROWED");
        bookService.updateBook(book);
        
        return true;
    }

    public boolean returnBook(int bookId) throws IOException {
        List<Transaction> transactions = transactionManager.loadTransactions();
        boolean found = false;

        for (Transaction t : transactions) {

            if (t.getBookId() == bookId && "BORROWED".equalsIgnoreCase(t.getStatus())) {
                
                t.setStatus("RETURNED");
                t.setReturnDate(java.time.LocalDate.now().toString());
                
                found = true;
                break; 
            }
        }

        if (found) {
            transactionManager.saveTransactions(transactions);

            Book book = getBookById(bookId);
            if (book != null) {
                book.setStatus("AVAILABLE");
                bookService.updateBook(book);
            }
        }
        
        return found;
    }

    public List<Transaction> getUserTransactions(int userId) throws IOException{
        return transactionManager.findByUserId(userId);
    }

    public boolean renewBook(int transactionId) throws IOException {
        List<Transaction> transactions = transactionManager.loadTransactions();
        boolean found = false;

        for (Transaction t : transactions) {
            if (t.getTransactionId() == transactionId) {
                
                if (!"BORROWED".equalsIgnoreCase(t.getStatus())) {
                    return false; 
                }

                String dateString = t.getDueDate();
                java.time.LocalDate currentDue = java.time.LocalDate.parse(dateString);
                java.time.LocalDate newDate = currentDue.plusDays(7);
                t.setDueDate(newDate.toString());
                
                found = true;
                break;
            }
        }

        if (found) {
            transactionManager.saveTransactions(transactions);
        }
        return found;
    }
    public List<Transaction> getAllTransactions() throws IOException {
    return transactionManager.loadTransactions(); 
}
}