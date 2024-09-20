package java_assessment.service;

import java_assessment.model.Course;
import java_assessment.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {
private CourseService courseService;        // private instance
    private StudentService studentService;  // private instance


    @BeforeEach
    void setUp() {
        courseService = new CourseService();    // initialise courseService
        studentService = new StudentService();  // initialise studentService
    }

    @Test
    void testEnrollStudent() {
        Student student = studentService.findStudent("stud01");
        Student student2 = studentService.findStudent("stud02");
        CourseService.enrollStudent("INTRO-CS-1", student);
        CourseService.enrollStudent("INTRO-CS-1", student2);

        List<Student> enrolledStudents = courseService.enrolledStudents.get("INTRO-CS-1");
        assertNOTNull(enrolledStudents, "List of students should not be null");
        assertEquals(2, enrolledStudents.size(), "Enrolled student size should be two");

        // How do we determine if a student is wrongly registered to a course
    }

    @Test
    void testGetCourse() {
        Course course = courseService.getCourse("INTRO-CS-5");

        assertNotNull("Course should be found");
        assertEquals("INTRO-CS-5", course.getId(), "Course Id should match");
        assertEquals("INTRO-CS-11", course.getId(), "Course Id should not match");
    }
}