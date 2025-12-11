package com.mycompany.controller;

import com.mycompany.model.User;
import com.mycompany.model.Admin;
import com.mycompany.model.Librarian;
import com.mycompany.model.Patron;
import java.util.ArrayList;

public class UserService {

    private static User currentUser = null;
    // 1. دالة تسجيل الدخول (Login)
    public boolean login(int id, String password, ArrayList<User> usersList) {
        for (User user : usersList) {
           
            if (user.getId() == id && user.getPassword().equals(password)) {
                currentUser = user; // 
                System.out.println("Login Successful! Welcome, " + user.getName());
                return true;
            }
        }
        System.out.println("Login Failed: Wrong ID or Password.");
        return false;
    }

   
    // 2. دالة تسجيل الخروج (Logout)
    public void logout() {
        if (currentUser != null) {
            System.out.println("Goodbye, " + currentUser.getName() + "!");
            currentUser = null; 
        } else {
            System.out.println("No user is logged in.");
        }
    }
    // 3. دالة تحديث البيانات (Update Info)
    public void updateUserInfo(String newPassword, String newEmail, String newPhone) {
        if (currentUser == null) {
            System.out.println("Error: You must login first.");
            return;
        }

        boolean isUpdated = false;

        // تحديث الباسورد لو اتبعتت
        if (newPassword != null && !newPassword.isEmpty()) {
            currentUser.setPassword(newPassword);
            System.out.println("- Password updated successfully.");
            isUpdated = true;
        }

        // تحديث الإيميل
        if (newEmail != null && !newEmail.isEmpty()) {
            currentUser.setEmail(newEmail);
            System.out.println("- Email updated successfully.");
            isUpdated = true;
        }

        // تحديث الموبايل
        if (newPhone != null && !newPhone.isEmpty()) {
            currentUser.setPhoneNumber(newPhone);
            System.out.println("- Phone number updated successfully.");
            isUpdated = true;
        }

        if (!isUpdated) {
            System.out.println("No changes were made.");
        }
    }
    // 4:(Check Role)
    public String getUserRole() {
        if (currentUser == null) {
            return "Guest"; // زائر 
        }

        //  عشان اعرف نوع الكلاس
        if (currentUser instanceof Admin) {
            return "Admin";
        } else if (currentUser instanceof Librarian) {
            return "Librarian";
        } else if (currentUser instanceof Patron) {
            return "Patron";
        } else {
            return "Unknown User";
        }
    }
    
    public static User getCurrentUser() {
        return currentUser;
    }
}