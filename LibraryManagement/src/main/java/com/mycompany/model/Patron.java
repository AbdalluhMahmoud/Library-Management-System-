package com.mycompany.model;

public class Patron extends User {

    
    private String address;

    public Patron() {
    }

    public Patron( int id, String name, String email, String password,String role,String phoneNumber, String address) {
        super(id, name, email, password,role,phoneNumber);
        
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patron{" + super.toString() + ", address=" + address + '}';
    }
    public class Patron {

    // Fields
    private String name;
    private String patronId;
    private String phone;
    private String email;
    private String address;
    private String memberShipDate;
    private int borrowedBooks;

    // Empty constructor
    public Patron() {
    }

    // Constructor without borrowedBooks (borrowedBooks defaults to 0)
    public Patron(String name, String address, String patronId, String phone, String email, String memberShipDate) {
        this.name = name;
        this.address = address;
        this.patronId = patronId;
        this.phone = phone;
        this.email = email;
        this.memberShipDate = memberShipDate;
        this.borrowedBooks = 0;
    }

    // Full constructor with borrowedBooks
    public Patron(String name, String address, String patronId, String phone, String email, String memberShipDate, int borrowedBooks) {
        this.name = name;
        this.address = address;
        this.patronId = patronId;
        this.phone = phone;
        this.email = email;
        this.memberShipDate = memberShipDate;
        this.borrowedBooks = borrowedBooks;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemberShipDate() {
        return memberShipDate;
    }

    public void setMemberShipDate(String memberShipDate) {
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
                ", patronId='" + patronId + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", memberShipDate='" + memberShipDate + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}

}
