package java_assessment.service;

import java_assessment.model.Course;
import java_assessment.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
class StudentServiceTest {

    private StudentService studentService;      // private or package private

    @BeforeEach
    void setUp() {
        studentService = new StudentService();  // create a new instance of StudentService before the test is run
    }

    @Test
    void testFindStudent() {
        Student student = studentService.findStudent("stu01");                                              // find the student stu01 created by StudentService

        assertNotNull(student, "Student should be found");                                                   // Check whether the student exists through assertions to determine we have found the student and details

        assertEquals("Adrian", student.getFirstName(), "FirstName of student should be Adrian");    // firstName should be "Adrian"
        assertEquals("Tan", student.getLastName(), "Last name should be Tan");
        assertEquals("adriantan@gmail.com", student.getEmail(), "email should be adriantan@gmail.com");

    }

    @Test
    void testNotFoundStudent(){
        Student student = studentService.findStudent("stu89");
        assertNull(student, "Student should NOT be found");
    }

    @Test
    void testisSubscribed() {
        assertTrue(studentService.isSubscribed("stud01"));  // Test that the student exists
        assertFalse(studentService.isSubscribed("stu00"));  // Test that the student does NOT exist
    }

    @Test

    void testIsAttendingCourse(){
        Course courseJava = new Course("Introduction to Java", "INTRO-CS-J", 100);
        Student student = new Student("Tony",
                                        "Stark",
                                            "tonystark@gmail.com",
                                        new Date(101,0,17),"stu01");
        student.enrollToCourse(courseJava);
        assertTrue(student.isAttendingCourse("INTRO-CS-J"), "Student should be attending course");
        assertFalse(student.isAttendingCourse("INTRO-CS-J"), "Student should NOT be in this course");

    }

}