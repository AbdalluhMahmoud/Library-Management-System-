package com.mycompany.model;

public class Admin extends User {

    public Admin(int id, String name, String email, String password,String role,String phoneNumber) {
        super(id, name, email, password,"Admin",phoneNumber);
    }

    @Override
    public String toString() {
        return "Admin{" + super.toString() + "}";
    }

}
