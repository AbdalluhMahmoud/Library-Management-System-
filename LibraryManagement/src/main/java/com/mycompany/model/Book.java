package com.mycompany.model;

public class Book {

    private int id;
    private String author;
    private String title;
    private String publisher;
    private int publish_year;
    private int copies_Available;
    private String type_ofBook;

    public Book() {
    }

    public Book(int id, String author, String title, String publisher, int publish_year, int copies_Available, String type_ofBook) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publish_year = publish_year;
        this.copies_Available = copies_Available;
        this.type_ofBook = type_ofBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(int publish_year) {
        this.publish_year = publish_year;
    }

    public int getCopies_Available() {
        return copies_Available;
    }

    public void setCopies_Available(int copies_Available) {
        this.copies_Available = copies_Available;
    }

    public String gettype_ofBook() {
        return type_ofBook;
    }

    public void settype_ofBook(String type_ofBook) {
        this.type_ofBook = type_ofBook;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", author=" + author + ", title=" + title + ", publisher=" + publisher + ", publish_year=" + publish_year + ", copies_Available=" + copies_Available + ", type_ofBook=" + type_ofBook + '}';
    }
    

    
}public class Book {

    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean isAvailable;

    public Book() {}

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true; // default when adding a new book
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + isbn + '\'' +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Year=" + year +
                ", Available=" + isAvailable +
                '}';
    }
}
