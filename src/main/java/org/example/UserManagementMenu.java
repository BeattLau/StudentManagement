package org.example;

import java.util.Scanner;

public class UserManagementMenu {
    private Scanner sc;
    private UserManagement userManagement;

    public UserManagementMenu(Scanner sc, UserManagement userManagement) {
        this.sc = sc;
        this.userManagement = userManagement;
    }

    public void userManagementMenu() {
        while (true) {
            System.out.println("User Management menu: ");
            System.out.println("1. Add user");
            System.out.println("2. Update user");
            System.out.println("3. Remove user");
            System.out.println("4. Search for user");
            System.out.println("5. Display all users");
            System.out.println("6. Back to main menu");
            System.out.println("Please enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Adding a user");
                    System.out.print("Enter the username: ");
                    String username = sc.next();
                    System.out.print("Enter the password: ");
                    String password = sc.next();
                    User newUser = new User(username, password);
                    userManagement.addUser(newUser);
                    System.out.println("User added successfully.");
                    break;

                case 2:
                    System.out.println("Updating a user");
                    System.out.print("Enter the username to update: ");
                    String userName = sc.next();
                    System.out.print("Enter the new password: ");
                    String newPassword = sc.next();
                    userManagement.updateUser(userName, newPassword);
                    break;

                case 3:
                    System.out.println("Deleting a user");
                    System.out.print("Enter the username to delete: ");
                    String usernameToDelete = sc.next();
                    User userToDelete = userManagement.searchForUser(usernameToDelete);

                    if (userToDelete != null) {
                        userManagement.removeUser(userToDelete);
                        System.out.println("User deleted successfully.");
                    } else {
                        System.out.println("User not found. Deletion failed.");
                    }
                    break;

                case 4:
                    System.out.println("Searching for a user");
                    System.out.print("Enter the username to search for: ");
                    String usernameToSearch = sc.next();
                    User foundUser = userManagement.searchForUser(usernameToSearch);

                    if (foundUser != null) {
                        System.out.println("User found:");
                        System.out.println("Username: " + foundUser.getUsername() + ", Password: " + foundUser.getPassword());
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 5:
                    System.out.println("Display all users");
                    userManagement.displayUsers();
                    break;

                case 6:
                    System.out.println("Returning to main menu");
                    return;

                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
    }
}

