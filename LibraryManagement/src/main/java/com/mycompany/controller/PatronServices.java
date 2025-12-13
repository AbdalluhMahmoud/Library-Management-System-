import java.util.ArrayList;
import java.io.*;

public class PatronManager {

    static void addPtron(Patron Patron) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private ArrayList<Patron> patrons;

    public PatronManager() {
        patrons = new ArrayList<>();
    }

    // Add a new patron
    public void addPatron(Patron p) {
        patrons.add(p);
        System.out.println("Patron added: " + p.getName());
    }

    // Search by ID
    public Patron searchById(String id) {
        for (Patron p : patrons) {
            if (p.getPatronId().equals(id)) return p;
        }
        return null;
    }

    // Update patron
    public boolean updatePatron(String id, Patron updatedPatron) {
        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getPatronId().equals(id)) {
                patrons.set(i, updatedPatron);
                System.out.println("Patron with ID " + id + " updated.");
                return true;
            }
        }
        System.out.println("Patron with ID " + id + " not found.");
        return false;
    }

    // Delete patron
    public boolean deletePatron(String id) {
        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getPatronId().equals(id)) {
                patrons.remove(i);
                System.out.println("Patron with ID " + id + " deleted.");
                return true;
            }
        }
        System.out.println("Patron with ID " + id + " not found.");
        return false;
    }

    // Show all patrons
    public void showAllPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("No patrons found.");
        } else {
            System.out.println("=== All Patrons ===");
            for (Patron p : patrons) {
                System.out.println(p);
            }
        }
    }

    // Save patrons to file
    public void saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Patron p : patrons) {
                pw.println(p.getName() + "," +
                           p.getAddress() + "," +
                           p.getPatronId() + "," +
                           p.getPhone() + "," +
                           p.getEmail() + "," +
                           p.getMemberShipDate() + "," +
                           p.getBorrowedBooks());
            }
        } catch (IOException e) {
            System.out.println("Error saving patrons: " + e.getMessage());
        }
    }

    // Load patrons from file
    public void loadFromFile(String filename) {
        patrons.clear(); // clear current list
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String name = parts[0];
                    String address = parts[1];
                    String patronId = parts[2];
                    String phone = parts[3];
                    String email = parts[4];
                    String memberShipDate = parts[5];
                    int borrowedBooks = Integer.parseInt(parts[6]);
                    patrons.add(new Patron(name, address, patronId, phone, email, memberShipDate, borrowedBooks));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with an empty list.");
        } catch (IOException e) {
            System.out.println("Error loading patrons: " + e.getMessage());
        }
    }
}
