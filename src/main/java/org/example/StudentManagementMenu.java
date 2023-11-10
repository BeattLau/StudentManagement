package org.example;

import java.util.Scanner;

public class StudentManagementMenu {
    private Scanner sc;
    private StudentManagement studentManagement;

    public StudentManagementMenu(Scanner sc, StudentManagement studentManagement) {
        this.sc = sc;
        this.studentManagement = studentManagement;
    }

    public void studentManagementMenu() {
        while (true) {
            System.out.println("Student information menu");
            System.out.println("1. Add student");
            System.out.println("2. Update student details");
            System.out.println("3. Remove student");
            System.out.println("4. Search for student");
            System.out.println("5. Back to main menu");
            System.out.println("Please enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Adding a student");
                    System.out.print("Enter the name: ");
                    String name = sc.next();
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter enrolled courses: ");
                    String enrolledCourses = sc.nextLine();

                    Student newStudent = new Student(name, id, enrolledCourses);

                    studentManagement.addStudent(newStudent);

                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.println("Updating a student");
                    System.out.print("Enter student id to update: ");
                    int idToUpdate = sc.nextInt();
                    sc.nextLine();
                    Student studentToUpdate = studentManagement.searchForStudent(idToUpdate);

                    if (studentToUpdate != null) {
                        System.out.print("Enter the new name: ");
                        String newName = sc.next();
                        System.out.print("Enter the new enrolled courses: ");
                        String newEnrolledCourses = sc.next();

                        studentManagement.updateStudentDetails(newName, idToUpdate, newEnrolledCourses);
                        System.out.println("Student details updated successfully.");
                    } else {
                        System.out.println("Student not found. Update failed.");
                    }
                    break;

                case 3:
                    System.out.println("Deleting student");
                    System.out.print("Enter the id to delete: ");
                    int idToDelete = sc.nextInt();
                    sc.nextLine();
                    Student studentToDelete = studentManagement.searchForStudent(idToDelete);

                    if (studentToDelete != null) {
                        studentManagement.removeStudent(studentToDelete);
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found. Deletion failed.");
                    }
                    break;

                case 4:
                    System.out.println("Searching for a student");
                    System.out.print("Enter the id to search for: ");
                    int idToSearch = Integer.parseInt(sc.next());
                    sc.nextLine();
                    Student foundStudent = studentManagement.searchForStudent(idToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found: ");
                        System.out.println("Name: " + foundStudent.getName() + ", Student ID: " + foundStudent.getStudentId() + "Enrolled courses: " + foundStudent.getEnrolledCourses());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.println("Returning to main menu");
                    return;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
    }
}
