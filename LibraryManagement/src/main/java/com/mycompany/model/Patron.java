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

}
