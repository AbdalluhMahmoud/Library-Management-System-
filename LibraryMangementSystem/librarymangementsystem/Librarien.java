/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 11
 */
package com.mycompany.book_store;

public class Librarian extends User{
  private String employee_ID;

    public Librarian() {
    }

    public Librarian(String employee_ID, String id, String name, String email, String password) {
        super(id, name, email, password);
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
