package org.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Course implements Comparable<Course>, Serializable {
    private String courseName;
    private int courseID;
    private String enrolledStudents;
    private Map<Integer, Double> studentGrades;

    public Course(String courseName, int courseID, String enrolledStudents) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.enrolledStudents = enrolledStudents;
        this.studentGrades = new HashMap<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(String enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public void addGrade(int studentId, double grade) {
        studentGrades.put(studentId, grade);
    }

    public void updateGrade(int studentId, double newGrade) {
        if (studentGrades.containsKey(studentId)) {
            studentGrades.put(studentId, newGrade);
        }
    }

    public Double getGrade(int studentId) {
        return studentGrades.get(studentId);
    }

    public void displayGrades() {
        for (Map.Entry<Integer, Double> entry : studentGrades.entrySet()) {
            int studentId = entry.getKey();
            double grade = entry.getValue();
            System.out.println("Student ID: " + studentId + ", Grade: " + grade);
        }
    }

    @Override
    public int compareTo(Course other) {
        return this.courseName.compareTo(other.courseName);
    }
}

