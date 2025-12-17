package com.mycompany.model;

public class Admin extends User {

    public Admin(int id, String role, String name, String username, String password, String email, String phone) {
        super(id, name,username, email, password,role,phone);
    }

    @Override
    public String toString() {
        return "Admin{" + super.toString() + "}";
    }

}
