package org.example;

import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable {
    String name;
    int studentId;
    String enrolledCourses;

    public Student(String name, int studentId, String enrolledCourses) {
        this.name = name;
        this.studentId = studentId;
        this.enrolledCourses = enrolledCourses;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(String enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}
