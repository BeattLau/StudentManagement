import org.example.Student;
import org.example.StudentManagement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentManagementTest {
    StudentManagement studentManagement = new StudentManagement();
    @Test
    public void testAddStudent() {
        Student student = new Student("John", 1, "Math, Science");
        studentManagement.addStudent(student);
        assertTrue(studentManagement.getStudentList().contains(student));
    }
    @Test
    public void testUpdateStudentDetails() {
        Student student = new Student("John", 1, "Math, Science");
        studentManagement.addStudent(student);

        studentManagement.updateStudentDetails("Alice", 1, "History, English");
        Student updatedStudent = studentManagement.searchForStudent(1);
        assertNotNull(updatedStudent);
        assertEquals("Alice", updatedStudent.getName());
        assertEquals("History, English", updatedStudent.getEnrolledCourses());
    }

    @Test
    public void testRemoveStudent() {
        Student student = new Student("John", 1, "Math, Science");
        studentManagement.addStudent(student);

        studentManagement.removeStudent(student);
        assertFalse(studentManagement.getStudentList().contains(student));
    }

    @Test
    public void testSearchForStudent() {
        Student student = new Student("John", 1, "Math, Science");
        studentManagement.addStudent(student);

        Student foundStudent = studentManagement.searchForStudent(1);
        assertNotNull(foundStudent);
        assertEquals(student, foundStudent);
    }
}

