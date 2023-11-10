package org.example;

import java.util.ArrayList;
import java.util.List;

public class CourseManagement {
    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public CourseManagement() {
        this.courseList = new ArrayList<>();
    }

    public void addNewCourse(Course course) {
        courseList.add(course);
        System.out.println("New course added successfully.");
    }

    public void updateCourse(String newCourseName, int courseId, String newEnrolledStudents) {
        Course courseToUpdate = searchForCourse(courseId);

        if (courseToUpdate != null) {
            courseToUpdate.setCourseName(newCourseName);
            courseToUpdate.setEnrolledStudents(newEnrolledStudents);
            System.out.println("Course details updated successfully.");
        } else {
            System.out.println("Course not found. Update failed.");
        }
    }

    public void removeACourse(Course course) {
        courseList.remove(course);
        System.out.println("Course removed successfully.");
    }

    public Course searchForCourse(int courseIdToSearch) {
        for (Course course : courseList) {
            if (course.getCourseID() == courseIdToSearch) {
                return course;
            }
        }
        return null;
    }
}
