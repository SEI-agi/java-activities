package java_assessment.service;


import java_assessment.model.Course;
import java_assessment.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public StudentService() {
        subscribeStudent( new Student( "Adrian", "Tan", "adriantan@gmail.com", new Date(101,0,17),"stu01"));     // 2001 Jan 17
        subscribeStudent( new Student( "Goh", "Hui Xin", "gohhuixin@hotmail.com", new Date(102,8,4), "stu02") ); // 2002 Sep 4
        subscribeStudent( new Student( "Alex", "Lim", "alexlim@gmail.com", new Date(103,4,30), "stu03") );       // 2003 May 30
    }

    public void subscribeStudent( Student student ) {
        students.put( student.getId(), student );
    }


    public Student findStudent(String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public boolean isSubscribed( String studentId )
    {
        //TODO implement this method
        return students.containsKey(studentId);
    }

    public void showSummary()
    {
        //TODO implement
        //TODO 1. display a title for this feature
        //TODO 2. list each student AND the course(s) the student is enrolled into approvedCourses
        System.out.println("Students and the courses enrolled into");
        for (String key: students.keySet()){
            Student student = students.get(key);
            student.printFullName();

            List<Course> courses = student.getApprovedCourses();

            if(courses == null) {
                System.out.println("\t\t No Course Found.");
            }else{
                for(Course course: courses){
                    System.out.println("\t\t" + course);
                }
            }
        }
    }

    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            Student student = students.get(studentId);
            student.enrollToCourse( course );
        }
    }

    // Challenge
    // TODO 1. Implement a way to store grades for each course a student is taking. There should be a way to update/set the score. Afterwards, fill in the public List<Course> findPassedCourses( Course course ) method in Student.java

    // Student.java
// Import the ArrayList class from the Java Collections Framework
import java.util.ArrayList;

    // Define the Student class
    public class Student {

        // Declare a private variable to store the name of the student
        private String name;

        // Declare a private variable to store the grade of the student
        private int grade;

        // Declare a private ArrayList to store the courses of the student
        private ArrayList courses;

        // Constructor for the Student class
        public Student(String name, int grade) {
            // Initialize the name of the student
            this.name = name;

            // Initialize the grade of the student
            this.grade = grade;

            // Initialize the courses ArrayList
            this.courses = new ArrayList();
        }

        // Method to get the name of the student
        public String getName() {
            // Return the name of the student
            return name;
        }

        // Method to get the grade of the student
        public int getGrade() {
            // Return the grade of the student
            return grade;
        }

        // Method to get the courses of the student
        public ArrayList getCourses() {
            // Return the courses ArrayList
            return courses;
        }


        // Method to print the details of the student
        public void printStudentDetails() {
            // Print the name of the student
            System.out.println("Name: " + name);

            // Print the grade of the student
            System.out.println("Grade: " + grade);
        }
    }



    // TODO 2. Implement an additional feature in the menu options that will display the average grade of all the students subscribed to a given course.

    static int[] studentGrade;
    static int gradeMax = 0;
    static int gradeMin = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("How many students are you entering into the database?");
        int numOfKids = input.nextInt();

        studentGrade = new int[numOfKids];
        studentName = new String[numOfKids];

        for (int i = 0; i < numOfKids; i++) {
            System.out.println("Enter the student's name:");
            studentName[i] = input.next();
            System.out.println("Enter " + studentName[i] + "'s grade");
            studentGrade[i] = input.nextInt();
        }

        do {

            System.out.println("");
            System.out.println("Enter a number for the following options:");
            System.out.println("");
            System.out.println("1. Student's letter grade");
            System.out.println("2. Search for a student and their grade");
            System.out.println("3. The class average");
            System.out.println("4. The student with the highest grade");
            System.out.println("5. The student with the lowest grade");
            System.out.println("6. List of students that are failing");
            System.out.println("7. Quit the program");
            int options = input.nextInt();

            switch(options) {
                case 1:
                    letterGrade(options); break;
                case 2:
                    searchStudent(); break;
                case 3:
                    classAvg(options); break;
                case 4:
                    markHighest(options); break;
                case 5:
                    markLowest(options); break;
                case 6:
                    markFailing(options); break;
                case 7:
                    return;
                default:
                    System.out.println("");
                    System.out.println("Please enter a valid option.");
                    System.out.println(""); break;

            }

        } while (!input.equals(7));
        System.out.println("Program Terminated.");

    }

    public static void letterGrade(int numOfKids) {

        System.out.println("Enter a grade: A, B, C, D, F");
        letterGrade = input.next();

        if (letterGrade.equalsIgnoreCase("a")) {
            gradeMax = 100;
            gradeMin = 80;
        }
        if (letterGrade.equalsIgnoreCase("b")) {
            gradeMax = 79;
            gradeMin = 70;
        }
        if (letterGrade.equalsIgnoreCase("c")) {
            gradeMax = 69;
            gradeMin = 60;
        }
        if (letterGrade.equalsIgnoreCase("d")) {
            gradeMax = 59;
            gradeMin = 50;
        }
        if (letterGrade.equalsIgnoreCase("f")) {
            gradeMax = 49;
            gradeMin = 0;
        }

        for (int i = 0; i < numOfKids; i++) {
            if (studentGrade[i] <= gradeMax && studentGrade[i] >= gradeMin) {
                System.out.println(studentName[i] + " has a " + letterGrade);
                System.out.println(letterGrade + " is equivalent to " + gradeMin + " - " + gradeMax + "%");
            }

        }

    }

    public static void searchStudent() {

    }

    public static void classAvg(int numOfKids) {

        int average = 0;

        for (int i = 0; i < numOfKids; i++) {
            average += studentGrade[i];
        }

        average = (average/numOfKids) * 100;

        System.out.println("The average of the class will be " + average + "%");

    }

    public static void markHighest(int numOfKids) {

        int highestNum = 0;

        for (int i = 0; i < numOfKids; i++) {

            if (studentGrade[i] > highestNum) {
                highestNum = studentGrade[i];
            }

        }

        System.out.println("The highest mark in the class is " + highestNum + "%");

    }

    public static void markLowest(int numOfKids) {

        int lowestNum = 0;

        for (int i = 0; i < numOfKids; i++) {

            if (studentGrade[i] < lowestNum) {
                lowestNum = studentGrade[i];
            }

        }

        System.out.println("The highest mark in the class is " + lowestNum + "%");

    }

    public static void markFailing(int numOfKids) {

        for (int i = 0; i < numOfKids; i++) {
            if (studentGrade[i] < 50) {
                System.out.println(studentName[i] + " is failing with a mark of " + studentGrade[i] + "%");
            }
        }

    }

}
}