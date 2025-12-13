import java.util.Scanner;

public class Main {

    private static final String PATRON_FILE = "patrons.txt";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        PatronManager pm = new PatronManager();
        BooksManaging bm = new BooksManaging();

        // Load existing patrons (if file exists)
        pm.loadFromFile(PATRON_FILE);

        // Preload some books (optional)
        bm.addBook(new Book("1", "Java Basics", "John Doe", 2022));
        bm.addBook(new Book("2", "Data Structures", "Jane Smith", 2023));
        bm.addBook(new Book("3", "Algorithms", "Alice Brown", 2021));
         bm.addBook(new Book("1", "python for dummies", "John .s", 2022));
        bm.addBook(new Book("2", "machine learning ", "Jane Smith", 2023));
        bm.addBook(new Book("3", "operating systems ", "Alice Brown", 2021));

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Library System Menu ===");
            System.out.println("1. Add Patron");
            System.out.println("2. Search Patron by ID");
            System.out.println("3. Update Patron by ID");
            System.out.println("4. Delete Patron by ID");
            System.out.println("5. Show All Patrons");
            System.out.println("6. Add Books");
            System.out.println("7. Search Book by  Number" );
            System.out.println("8. Update Book by Book Number");
            System.out.println("9. Delete Book by Book Number");
            System.out.println("10. Show All Books");
            System.out.println("11. Borrow Book");
            System.out.println("12. Return Book");
            System.out.println("13. Exit");
            System.out.print("Choose an option (1-13): ");

            int choice = in.nextInt();
            in.nextLine(); // consume newline

            switch (choice) {
                // ==== Patron Options ====
                case 1:
                    Patron newPatron = readPatronFromInput(in);
                    pm.addPatron(newPatron);
                    pm.saveToFile(PATRON_FILE);
                    break;

                case 2:
                    System.out.print("Enter Patron ID to search: ");
                    String searchId = in.nextLine();
                    Patron found = pm.searchById(searchId);
                    System.out.println(found != null ? found : "Patron not found.");
                    break;

                case 3:
                    System.out.print("Enter Patron ID to update: ");
                    String updateId = in.nextLine();
                    Patron updatedPatron = readPatronFromInput(in);
                    if (pm.updatePatron(updateId, updatedPatron)) {
                        pm.saveToFile(PATRON_FILE);
                    }
                    break;

                case 4:
                    System.out.print("Enter Patron ID to delete: ");
                    String deleteId = in.nextLine();
                    if (pm.deletePatron(deleteId)) {
                        pm.saveToFile(PATRON_FILE);
                    }
                    break;

                case 5:
                    pm.showAllPatrons();
                    break;

                // ==== Book Options ====
                case 6:
                    System.out.print("How many books do you want to add? ");
                    int n = in.nextInt();
                    in.nextLine(); // consume newline
                    for (int i = 0; i < n; i++) {
                        Book newBook = readBookFromInput(in);
                        bm.addBook(newBook);
                    }
                    break;

                case 7:
                    System.out.print("Enter ISBN to search: ");
                    String searchIsbn = in.nextLine();
                    Book foundBook = bm.searchByIsbn(searchIsbn);
                    System.out.println(foundBook != null ? foundBook : "Book not found.");
                    break;
                case 8:
                    System.out.print("Enter ISBN to update: ");
                    String updateIsbn = in.nextLine();
                    Book updatedBook = readBookFromInput(in);
                    bm.updateBook(updateIsbn, updatedBook);
                    break;

                case 9:
                    System.out.print("Enter ISBN to delete: ");
                    String deleteIsbn = in.nextLine();
                    bm.deleteBook(deleteIsbn);
                    break;

                case 10:
                    bm.showAllBooks();
                    break;

                case 11:
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowIsbn = in.nextLine();
                    bm.borrowBook(borrowIsbn);
                    break;

                case 12:
                    System.out.print("Enter ISBN to return: ");
                    String returnIsbn = in.nextLine();
                    bm.returnBook(returnIsbn);
                    break;

                case 13:
                    exit = true;
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        in.close();
    }

    // ===== Helper Methods =====
    private static Patron readPatronFromInput(Scanner in) {
        System.out.println("\nEnter Patron details:");
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Address: ");
        String address = in.nextLine();
        System.out.print("Patron ID: ");
        String patronId = in.nextLine();
        System.out.print("Phone: ");
        String phone = in.nextLine();
        System.out.print("Email: ");
        String email = in.nextLine();
        System.out.print("Membership Date (e.g., 2025-12-11): ");
        String memberShipDate = in.nextLine();
        int borrowedBooks = 0;
        return new Patron(name, address, patronId, phone, email, memberShipDate, borrowedBooks);
    }

    private static Book readBookFromInput(Scanner in) {
        System.out.println("\nEnter Book details:");
        System.out.print("Title: ");
        String title = in.nextLine();
        System.out.print("Author: ");
        String author = in.nextLine();
        System.out.print("ISBN: ");
        String isbn = in.nextLine();
        System.out.print("Publication Year: ");
        int year = in.nextInt();
        in.nextLine(); // consume newline
        return new Book(isbn, title, author, year);
    }
}
                
