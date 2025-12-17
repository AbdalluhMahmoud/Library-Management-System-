package com.mycompany.TextFiles;


import com.mycompany.model.User;
import java.io.*;
import java.util.*;

public class UserFileManager {
    private String fileName;
    public UserFileManager(String fileName){
        this.fileName=fileName;
    }
    public List<User> loadUsers() throws IOException {
        List<String> lines=FileHelper.readFile(fileName);
        List<User> users=new ArrayList<>();
        for(String line:lines){
            if(!line.trim().isEmpty()){
                users.add(User.fromCSV(line));
            }
        }
        return users;
    }
    
    public void saveUsers(List<User>users)throws IOException{
        List<String> lines = new ArrayList<>();
        for(User u : users){
            lines.add(u.toCSV());
        }
        FileHelper.writeFile(fileName, lines);
    }
    public void addUser(User u) throws IOException{
        FileHelper.appendLine(fileName, u.toCSV());
    }
    public User finfUserById(int id) throws IOException{
        List<User> users = loadUsers();
        for(User u : users){
            if(u.getId()==id){
                return u;
            }
        }
        return null;
    }
    public User findUser(String userName) throws IOException{
        List<User> users = loadUsers();
        for(User u : users){
            if(u.getUsername().equals(userName)){
                return u;
            }
        }
        return null;
    }
    public boolean deleteUser(int id) throws IOException{
        List<User> users = loadUsers();
        boolean removed = false;
        Iterator <User> it = users.iterator();
        while(it.hasNext()){
            User u = it.next();
            if(u.getId()==id){
                it.remove();
                removed = true;
                break;
            }
        }
        if(removed){
            saveUsers(users);
        }
        return removed;
    }
    public boolean updateUser(User updatedUser) throws IOException{
        List<User> users=loadUsers();
        boolean updated = false;
        for(int i =0;i<users.size();i++){
            if(users.get(i).getId()==updatedUser.getId()){
                users.set(i, updatedUser);
                updated= true;
                break;
            }
        }
        if(updated){
            saveUsers(users);
        }
        return updated;
    }
    public User login(String username,String password)throws IOException {
        List<User> users=loadUsers();
        for(User u : users){
            if(u.getUsername().equals(username)&&u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    public List<User> searchUsers(String keyword) throws IOException {
   
    List<User> allUsers = loadUsers(); 
    List<User> result = new ArrayList<>();
    
    String search = keyword.toLowerCase(); 
    
    for (User u : allUsers) {
        
        if (String.valueOf(u.getId()).contains(search) || 
            u.getName().toLowerCase().contains(search) || 
            u.getUsername().toLowerCase().contains(search) ||
            u.getRole().toLowerCase().contains(search) ||
            u.getEmail().toLowerCase().contains(search) ||
            u.getPhone().contains(search)) {
            
            result.add(u);
        }
    }
    return result;
}

    private List<User> getAllUsers() throws IOException {
    return loadUsers();
}
}
