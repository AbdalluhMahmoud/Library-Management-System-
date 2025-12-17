package com.mycompany.TextFiles;

import com.mycompany.model.Transaction;
import com.mycompany.model.Book;
import java.io.*;
import java.util.*;

public class TransactionService {
    private TransactionFileManager transactionManager;
    private BookService bookService;
    
    public TransactionService(String transactionFile,String bookFile){
        this.transactionManager=new TransactionFileManager(transactionFile);
        this.bookService=new BookService(bookFile);
    }
    
    private int generateNewId() throws IOException{
        List<Transaction> list=transactionManager.loadTransactions();
        int max=0;
        for(Transaction t:list){
            if(t.getTransactionId()>max) max=t.getTransactionId();
        }
        return max+1;
    }
    
    public boolean borrowBook(int userId,int bookId,String borrowDate,String dueDate) throws IOException{
        List<Book> books=bookService.getAllBooks();
        Book target=null;
        for(Book b:books){
            if(b.getId()==bookId && b.getStatus().equals("AVAILABLE")){
                target=b;
                break;
            }
        }
        if(target==null) return false;

        int id=generateNewId();
        Transaction t=new Transaction(id,userId,bookId,borrowDate,dueDate,"","BORROWED");
        transactionManager.addTransaction(t);

        target.setStatus("BORROWED");
        bookService.updateBook(target);
        return true;
    }
    
    public boolean returnBook(int transactionId,String returnDate) throws IOException{
        Transaction t=transactionManager.findById(transactionId);
        if(t==null || t.getStatus().equals("RETURNED")) return false;

        t.setReturnDate(returnDate);
        t.setStatus("RETURNED");
        transactionManager.updateTransaction(t);

        List<Book> books=bookService.getAllBooks();
        for(Book b:books){
            if(b.getId()==t.getBookId()){
                b.setStatus("AVAILABLE");
                bookService.updateBook(b);
                break;
            }
        }
        return true;
    }
    
    public List<Transaction> getUserTransactions(int userId) throws IOException{
        return transactionManager.findByUserId(userId);
    }
}
