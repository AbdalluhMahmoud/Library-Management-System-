package com.mycompany.model;

public class Librarian extends User {




    public Librarian( int id, String role, String name, String username, String password, String email, String phone) {
        super(id, name,username, email, password,role,phone);

    }
    
    @Override
    public String toString() {
        return "Librarian{" + super.toString();
    }


  
    }