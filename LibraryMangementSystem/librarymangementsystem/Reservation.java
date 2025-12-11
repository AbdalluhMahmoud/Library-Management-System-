package com.mycompany.book_store;


import java.time.LocalDate;

public class Reservation {
    private String reservation_Id; //Unique identifier for the reservation
    private Patron patron; //The user who made the reservation
    private Book book; //The book that is reserved
    private LocalDate reservation_Date; //The date when the reservation was made
    private String status; //Current status of the reservation (Active, Cancelled, Expired)

   
    public Reservation() {}

    
    public Reservation(String reservation_Id, Patron patron, Book book, LocalDate reservation_Date, String status) {
        this.reservation_Id = reservation_Id;
        this.patron = patron;
        this.book = book;
        this.reservation_Date = reservation_Date;
        this.status = status;
    }

    public String getReservation_Id() {
        return reservation_Id;
    }

    public void setReservation_Id(String reservation_Id) {
        this.reservation_Id = reservation_Id;
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

    public LocalDate getReservation_Date() {
        return reservation_Date;
    }

    public void setReservation_Date(LocalDate reservation_Date) {
        this.reservation_Date = reservation_Date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
   
    @Override
    public String toString() {
        return "Reservation{" + "reservation_Id=" + reservation_Id + ", patron=" + patron + ", book=" + book + ", reservation_Date=" + reservation_Date + ", status=" + status + '}';
    }
    
    }
