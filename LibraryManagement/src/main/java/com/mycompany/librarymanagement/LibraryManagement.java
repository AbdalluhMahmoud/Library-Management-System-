package com.mycompany.librarymanagement;

import com.mycompany.controller.AdminService;
import com.mycompany.model.Admin;
import com.mycompany.model.Book;


public class LibraryManagement {

    public static void main(String[] args) {
        
        Admin admin =new Admin(1,"ahmed","sayed@gmail.com","Admin","123","010123");
       System.out.println(admin.getName());
        System.out.println(admin.getEmail());
        System.out.println(admin.getId());
        System.out.println(admin.getRole());
        System.out.println(admin.getPassword());
        
        AdminService admin2 = new AdminService();
        Book pl2 = new Book(1,"ahmed","abbas","احمد حمص",2025,20,"history");
       admin2.addBook(pl2);
       admin2.deleteBook(1);
    }
}
