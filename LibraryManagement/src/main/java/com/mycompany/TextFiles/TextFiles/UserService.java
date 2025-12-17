

import java.io.*;
import java.util.*;

public class UserService {

    private UserFileManager manager;

    public UserService(String fileName) {
        this.manager = new UserFileManager(fileName);
    }

    private int generateNewId() throws IOException {
        List<User> users = manager.loadUsers();
        int max = 0;
        for (User u : users) {
            if (u.getId() > max) {
                max = u.getId();
            }
        }
        return max + 1;
    }

    public boolean register(String role, String name, String username, String password, String email, String phone) throws IOException {

        User existing = manager.findUser(username);
        if (existing != null) {
            return false; 
        }

        int id = generateNewId();
        User newUser = new User(id, role, name, username, password, email, phone);

        manager.addUser(newUser);
        return true;
    }

    public User login(String username, String password) throws IOException {
        return manager.login(username, password);
    }

    public boolean updateUser(User updatedUser) throws IOException {
        return manager.updateUser(updatedUser);
    }

    public boolean deleteUser(int id) throws IOException {
        return manager.deleteUser(id);
    }

    public List<User> getAllUsers() throws IOException {
        return manager.loadUsers();
    }
}

