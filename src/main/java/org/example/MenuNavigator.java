package org.example;

import java.util.Scanner;

public class MenuNavigator {
    CourseManagement courseManagement = new CourseManagement();
    StudentManagement studentManagement = new StudentManagement();
    UserManagement userManagement = new UserManagement();
    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayMainMenu();
            int choice = sc.nextInt();

            MainMenuOption selectedOption = MainMenuOption.fromValue(choice);

            switch (selectedOption) {
                case USER_MANAGEMENT:
                    System.out.println("To user management menu");
                    UserManagementMenu userMenu = new UserManagementMenu(sc, userManagement);
                    userMenu.userManagementMenu();
                    break;
                case STUDENT_INFORMATION:
                    System.out.println("To student information menu");
                    StudentManagementMenu studentMenu = new StudentManagementMenu(sc, studentManagement);
                    studentMenu.studentManagementMenu();
                    break;
                case COURSE_MANAGEMENT:
                    System.out.println("To course management menu");
                    CourseManagementMenu courseMenu = new CourseManagementMenu(sc, courseManagement);
                    courseMenu.courseManagementMenu();
                    break;
                case EXIT:
                    System.out.println("Exiting system");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
    }

    void displayMainMenu() {
        System.out.println("Main menu: ");
        for (MainMenuOption option : MainMenuOption.values()) {
            System.out.println(option.getValue() + ". " + option.getDescription());
        }
        System.out.println("Please enter your choice: ");
    }
}

enum MainMenuOption {
    USER_MANAGEMENT(1, "User management"),
    STUDENT_INFORMATION(2, "Student Information management"),
    COURSE_MANAGEMENT(3, "Course management"),
    EXIT(4, "Exit");

    private final int value;
    private final String description;
    MainMenuOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
            return value;
        }
        public String getDescription() {
            return description;
        }
        public static MainMenuOption fromValue(int value) {
        for (MainMenuOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        return null;
    }
}
