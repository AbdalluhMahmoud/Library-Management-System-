package com.mycompany.book_store;


import java.time.LocalDate;

public class Checkout {  
    private String checkoutId; //Unique identifier for the checkout (borrowing)
    private Patron patron; //The user who borrowed the book
    private Book book; //The book that is borrowed
    private LocalDate checkoutDate; //The date when the book was borrowed
    private LocalDate dueDate; //The date by which the book should be returned
    private LocalDate returnDate; //The actual date when the book was returned (null if not yet returned)
    private String status; //Current status of the checkout (Borrowed, Returned, Late)

    public Checkout() {
    }

    public Checkout(String checkoutId, Patron patron, Book book, LocalDate checkoutDate, LocalDate dueDate, LocalDate returnDate, String status) {
        this.checkoutId = checkoutId;
        this.patron = patron;
        this.book = book;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Checkout{" + "checkoutId=" + checkoutId + ", patron=" + patron + ", book=" + book + ", checkoutDate=" + checkoutDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", status=" + status + '}';
    }
    

}
