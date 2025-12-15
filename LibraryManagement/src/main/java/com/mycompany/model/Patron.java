package com.mycompany.model;

import java.util.Date;

public class Patron extends User {
    

    private Date memberShipDate;
    private int borrowedBooks;
    private String address;

    public Patron() {
    }

    public Patron( int id, String name, String email, String password,String role,String phoneNumber, String address) {
        super(id, name, email, password,role,phoneNumber);
        
        this.address = address;
    }

    
    // Empty constructor

    // Constructor without borrowedBooks (borrowedBooks defaults to 0)
    public Patron(int id, String name, String email, String password,String role,String phoneNumber, Date memberShipDate) {
        super(id, name, email, password,role,phoneNumber);
        this.memberShipDate=memberShipDate;
        
    }

    // Full constructor with borrowedBooks
    public Patron(int id,String name, String email,  String password, String role,String phoneNumber, Date memberShipDate, int borrowedBooks) {
        super(id, name, email, password,role,phoneNumber);
        this.memberShipDate = memberShipDate;
        this.borrowedBooks = borrowedBooks;
    }

    // Getters and setters
   

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getMemberShipDate() {
        return memberShipDate;
    }

    public void setMemberShipDate(Date memberShipDate) {
        this.memberShipDate = memberShipDate;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(int borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    // toString method
    @Override
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", memberShipDate='" + memberShipDate + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}


