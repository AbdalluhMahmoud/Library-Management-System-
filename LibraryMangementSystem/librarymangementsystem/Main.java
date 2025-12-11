/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 11
 */
package com.mycompany.book_store;


public class Book_Store {

    public static void main(String[] args) {
           Book b1 = new Book("B001", "Author1", "Java Basics", "Pub1", 2023, 5, "Programming");
Patron p1 = new Patron("0123456789", "Cairo", "P001", "Ali", "ali@gmail.com", "pass123");
System.out.println(p1);

    }
    

}
