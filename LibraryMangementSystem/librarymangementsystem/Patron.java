/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 11
 */
package com.mycompany.book_store;


public class Patron extends User {
   private String phone_number;
   private String address;

    public Patron() {
    }

    public Patron(String phone_number, String address, String id, String name, String email, String password) {
        super(id, name, email, password);
        this.phone_number = phone_number;
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   @Override
public String toString() {
    return "Patron{" + super.toString() + ", phone_number=" + phone_number + ", address=" + address + '}';
}

}
