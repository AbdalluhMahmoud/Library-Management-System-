package com.mycompany.book_store;

import java.util.ArrayList;

public class AdminService {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Librarian> librarians = new ArrayList<>();

    

    public void addBook(Book book) {
        books.add(book);
        System.out.println("\n[✔] Book added successfully.\n");
    }

    public void deleteBook(String id) {
        boolean removed = books.removeIf(b -> b.getId().equals(id));

        if (removed) {
            System.out.println("\n[✔] Book deleted.\n");
        } else {
            System.out.println("\n[✖] Book not found.\n");
        }
    }

    public void updateBookTitle(String id, String newTitle) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                b.setTitle(newTitle);
                System.out.println("\n[✔] Book title updated.\n");
                return;
            }
        }
        System.out.println("\n[✖] Book not found.\n");
    }

    public Book searchBook(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
        System.out.println("\n[✔] Librarian added.\n");
    }

    public void deleteLibrarian(String id) {
        boolean removed = librarians.removeIf(l -> l.getId().equals(id));

        if (removed) {
            System.out.println("\n[✔] Librarian deleted.\n");
        } else {
            System.out.println("\n[✖] Librarian not found.\n");
        }
    }

    public Librarian searchLibrarian(String id) {
        for (Librarian l : librarians) {
            if (l.getId().equals(id)) {
                return l;
            }
        }
        return null;
    }

    

    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        books.forEach(System.out::println);
    }

    public void listAllLibrarians() {
        if (librarians.isEmpty()) {
            System.out.println("No librarians found.");
            return;
        }
        librarians.forEach(System.out::println);
    }
}
