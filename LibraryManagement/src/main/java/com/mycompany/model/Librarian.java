package com.mycompany.model;

public class Librarian extends User {

    private String employee_ID;

    public Librarian() {
    }

    public Librarian( int id, String name, String email, String password,String role,String phoneNumber,String employee_ID) {
        super(id, name, email, password,"Librarian",phoneNumber);
        this.employee_ID = employee_ID;
    }

    public String getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(String employee_ID) {
        this.employee_ID = employee_ID;
    }

    @Override
    public String toString() {
        return "Librarian{" + super.toString() + ", employee_ID=" + employee_ID + '}';
    }


  
    }