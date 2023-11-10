import org.example.Course;
import org.example.CourseManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseManagementTest {
    private ArrayList<Course> courseList;
    private CourseManagement courseManagement;

    @BeforeEach
    void setUp() {
        courseList = new ArrayList<>();
        courseManagement = new CourseManagement();
    }

    @Test
    public void testAddNewCourse() {
        Course course = new Course("Math", 101, "student1,student2");
        courseManagement.addNewCourse(course);
        assertTrue(courseManagement.getCourseList().contains(course));
    }

    @Test
    void testUpdateCourse() {
        Course course = new Course("Math", 101, "student1,student2");
        courseManagement.addNewCourse(course);

        courseManagement.updateCourse("NewMath", 101, "student2,student3");
        Course updatedCourse = courseManagement.searchForCourse(101);

        assertNotNull(updatedCourse, "Course should be found");
        assertEquals("NewMath", updatedCourse.getCourseName(), "Course name should be updated");
    }

    @Test
    void testRemoveACourse() {
        Course course = new Course("Math", 101, "student1,student2");
        courseManagement.addNewCourse(course);
        courseManagement.removeACourse(course);
        assertFalse(courseManagement.getCourseList().contains(course));
    }

    @Test
    void testSearchForCourse() {
        Course course1 = new Course("Math", 101, "student1,student2");
        Course course2 = new Course("English", 102, "student3,student4");
        courseManagement.addNewCourse(course1);
        courseManagement.addNewCourse(course2);

        Course foundCourse = courseManagement.searchForCourse(102);
        assertNotNull(foundCourse, "Course should be found");
        assertEquals(102, foundCourse.getCourseID(), "Found course's ID should match");
    }
}
