package org.example;

import java.util.Scanner;

public class CourseManagementMenu {
    private Scanner sc;
    private CourseManagement courseManagement;
    public CourseManagementMenu(Scanner sc, CourseManagement courseManagement) {
        this.sc = sc;
        this.courseManagement = courseManagement;
    }
    public void courseManagementMenu() {
        while (true) {
            System.out.println("Course management");
            System.out.println("1. Add a new course");
            System.out.println("2. Update a course");
            System.out.println("3. Remove a course");
            System.out.println("4. Search a course");
            System.out.println("5. Return to main menu");
            System.out.println("Please enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Adding a new course");
                    System.out.print("Enter course name: ");
                    String courseName = sc.next();
                    System.out.print("Enter course id: ");
                    int courseId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter enrolled students: ");
                    String enrolledStudents = sc.nextLine();

                    Course newCourse = new Course(courseName, courseId, enrolledStudents);

                    courseManagement.addNewCourse(newCourse);

                    System.out.println("Course added successfully.");
                    break;
                case 2:
                    System.out.println("Updating a course");
                    System.out.print("Enter course id to update: ");
                    int idToUpdate = sc.nextInt();
                    sc.nextLine();
                    Course courseToUpdate = courseManagement.searchForCourse(idToUpdate);

                    if (courseToUpdate != null) {
                        System.out.print("Enter the new name: ");
                        String newCourseName = sc.next();
                        System.out.print("Enter the new enrolled students: ");
                        String newEnrolledStudents = sc.next();

                        courseManagement.updateCourse(newCourseName, idToUpdate, newEnrolledStudents);
                        System.out.println("Course details updated successfully.");
                    } else {
                        System.out.println("Course not found. Update failed.");
                    }
                    break;
                case 3:
                    System.out.println("Searching for course");
                    System.out.print("Enter the id to search for: ");
                    int idToSearch = sc.nextInt();
                    sc.nextLine();
                    Course foundCourse = courseManagement.searchForCourse(idToSearch);
                    if (foundCourse != null) {
                        System.out.println("Course found: ");
                        System.out.println("Course name: " + foundCourse.getCourseName() + ", Course ID: " + foundCourse.getCourseID() + ", Enrolled students: " + foundCourse.getEnrolledStudents());
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 4:
                    System.out.println("Removing a course");
                    System.out.print("Enter course id to remove: ");
                    int courseIdToDelete = sc.nextInt();
                    sc.nextLine();
                    Course courseToDelete = courseManagement.searchForCourse(courseIdToDelete);

                    if (courseToDelete != null) {
                        courseManagement.removeACourse(courseToDelete);
                        System.out.println("Course deleted successfully.");
                    } else {
                        System.out.println("Course not found. Deletion failed.");
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
