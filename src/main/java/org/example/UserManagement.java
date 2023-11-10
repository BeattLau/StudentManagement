package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {
    private List<User> userList;

    public UserManagement(List<User> userList) {
        this.userList = userList;
    }

    public UserManagement() {
        this.userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
        System.out.println("User added successfully.");
    }

    public void updateUser(String userName, String newPassword) {
        User userToUpdate = searchForUser(userName);

        if (userToUpdate != null) {
            userToUpdate.setPassword(newPassword);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found. Update failed.");
        }
    }

    public void removeUser(User user) {
        userList.remove(user);
        System.out.println("User removed successfully.");
    }

    public User searchForUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void displayUsers() {
        System.out.println("All users: ");
        for (User user : userList) {
            System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
        }
    }

}
