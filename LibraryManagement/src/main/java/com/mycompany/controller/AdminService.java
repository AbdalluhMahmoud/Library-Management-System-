package com.mycompany.book_store;

import java.util.ArrayList;

public class AdminService {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Librarian> librarians = new ArrayList<>();

   

    public void addBook(Book book) {
        if (book == null) {
            System.out.println("[✖] Invalid book.");
            return;
        }
        books.add(book);
        System.out.println("[✔] Book added successfully.");
    }

    public void deleteBook(int id) {
        boolean removed = books.removeIf(b -> b.getId() == id);
        if (removed) {
            System.out.println("[✔] Book deleted.");
        } else {
            System.out.println("[✖] Book not found.");
        }
    }

    public void updateBookTitle(int id, String newTitle) {
        Book b = searchBook(id);
        if (b != null) {
            b.setTitle(newTitle);
            System.out.println("[✔] Book title updated.");
        } else {
            System.out.println("[✖] Book not found.");
        }
    }

    public void updateBookAuthor(int id, String newAuthor) {
        Book b = searchBook(id);
        if (b != null) {
            b.setAuthor(newAuthor);
            System.out.println("[✔] Book author updated.");
        } else {
            System.out.println("[✖] Book not found.");
        }
    }

    public void updateBookPublisher(int id, String newPublisher) {
        Book b = searchBook(id);
        if (b != null) {
            b.setPublisher(newPublisher);
            System.out.println("[✔] Book publisher updated.");
        } else {
            System.out.println("[✖] Book not found.");
        }
    }

    public void updateBookYear(int id, int newYear) {
        Book b = searchBook(id);
        if (b != null) {
            b.setPublish_year(newYear);
            System.out.println("[✔] Book year updated.");
        } else {
            System.out.println("[✖] Book not found.");
        }
    }

    public void updateBookCopies(int id, int newCopies) {
        Book b = searchBook(id);
        if (b != null) {
            b.setCopies_Available(newCopies);
            System.out.println("[✔] Book copies updated.");
        } else {
            System.out.println("[✖] Book not found.");
        }
    }

    public void updateBookCategory(int id, String newCategory) {
        Book b = searchBook(id);
        if (b != null) {
            b.settype_ofBook(newCategory);
            System.out.println("[✔] Book category updated.");
        } else {
            System.out.println("[✖] Book not found.");
        }
    }

    public Book searchBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        for (Book b : books) {
            System.out.println("------------------------------");
            System.out.println("ID: " + b.getId());
            System.out.println("Title: " + b.getTitle());
            System.out.println("Author: " + b.getAuthor());
            System.out.println("Publisher: " + b.getPublisher());
            System.out.println("Year: " + b.getPublish_year());
            System.out.println("Copies: " + b.getCopies_Available());
            System.out.println("Category: " + b.gettype_ofBook());
        }
        System.out.println("------------------------------");
    }

    

    public void addLibrarian(Librarian librarian) {
        if (librarian == null) {
            System.out.println("[✖] Invalid librarian.");
            return;
        }
        librarians.add(librarian);
        System.out.println("[✔] Librarian added successfully.");
    }

    public void deleteLibrarian(int id) {
        boolean removed = librarians.removeIf(l -> l.getId() == id);
        if (removed) {
            System.out.println("[✔] Librarian deleted.");
        } else {
            System.out.println("[✖] Librarian not found.");
        }
    }

    public Librarian searchLibrarian(int id) {
        for (Librarian l : librarians) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    public void listAllLibrarians() {
        if (librarians.isEmpty()) {
            System.out.println("No librarians found.");
            return;
        }
        for (Librarian l : librarians) {
            System.out.println("------------------------------");
            System.out.println("ID: " + l.getId());
            System.out.println("Name: " + l.getName());
            System.out.println("Email: " + l.getEmail());
            System.out.println("Employee ID: " + l.getEmployee_ID());
        }
        System.out.println("------------------------------");
    }
}

