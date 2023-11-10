package org.example;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private List<Student> studentList;

    public StudentManagement() {
        this.studentList = new ArrayList<>();
    }

    public List<Student> getStudentList(){
        return studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    public void updateStudentDetails(String newName, int studentId, String newEnrolledCourses) {
        Student studentToUpdate = searchForStudent(studentId);

        if (studentToUpdate != null) {
            studentToUpdate.setName(newName);
            studentToUpdate.setEnrolledCourses(newEnrolledCourses);
            System.out.println("Student details updated successfully.");
        } else {
            System.out.println("Student not found. Update failed.");
        }
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
        System.out.println("Student removed successfully.");
    }

    public Student searchForStudent(int idToSearch) {
        for (Student student : studentList) {
            if (student.getStudentId() == idToSearch) {
                return student;
            }
        }
        return null;
    }
}
