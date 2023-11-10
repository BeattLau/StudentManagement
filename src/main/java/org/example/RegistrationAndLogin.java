package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistrationAndLogin {
    private Map<String, User> users = new HashMap<>();

    public enum MenuOption {
        REGISTER, LOGIN, EXIT
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            MenuOption menuOption = MenuOption.values()[choice - 1];

            switch (menuOption) {
                case REGISTER:
                    registerUser(sc);
                    break;
                case LOGIN:
                    loginUser(sc);
                    break;
                case EXIT:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void registerUser(Scanner sc) {
        System.out.print("Enter a username: ");
        String username = sc.next();
        System.out.print("Enter a password: ");
        String password = sc.next();

        User newUser = new User(username, password);
        users.put(username, newUser);

        System.out.println("User registered successfully!");
    }

    private void loginUser(Scanner sc) {
        System.out.print("Enter your username: ");
        String username = sc.next();
        System.out.print("Enter your password: ");
        String password = sc.next();

        User user = users.get(username);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }
    }
}

