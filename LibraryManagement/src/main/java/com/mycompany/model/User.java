package com.mycompany.model;


 
 public class User{
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
        int id = Integer.parseInt(parts[0]);
        return new User(id, parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }
}
