package com.mycompany.model;


 
public abstract class User implements CSVConvertible{
    protected int id;
    protected String role;
    protected String name;
    protected String username;
    protected String password;
    protected String email;
    protected String phone;
    
     public User(int id, String role, String name, String username, String password, String email, String phone) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
     public int getId() { return id; }
    public String getRole() { return role; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    public void setRole(String role) { this.role = role; }
    public void setName(String name) { this.name = name; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String toCSV() {
        return id + "," + role + "," + name + "," + username + "," + password + "," + email + "," + phone;
    }
    
    public static User fromCSV(String line) {
        String[] parts = line.split(",");
        
        if (parts.length < 7) return null; 

        int id = Integer.parseInt(parts[0]);
        String role = parts[1];
        String name = parts[2];
        String username = parts[3];
        String password = parts[4];
        String email = parts[5];
        String phone = parts[6];

       if (role.equalsIgnoreCase("Admin")) {
            return new Admin(id, role, name, username, password, email, phone);
        } 
        else if (role.equalsIgnoreCase("Librarian")) {
            return new Librarian(id, role, name, username, password, email, phone);
        } 
        else {
            // Default to Patron for everyone else
            return new Patron(id, role, name, username, password, email, phone);
        }
    }
}
