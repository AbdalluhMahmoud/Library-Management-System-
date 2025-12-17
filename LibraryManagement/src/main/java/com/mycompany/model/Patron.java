package com.mycompany.model;

public class Patron extends User {
    

    public Patron( int id, String role, String name, String username, String password, String email, String phone) {
        super(id, name,username, email, password,role,phone);
        
    }

    @Override
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", email='" + email
                ;
    }
}


