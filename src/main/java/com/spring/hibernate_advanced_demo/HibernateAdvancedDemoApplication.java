package com.spring.hibernate_advanced_demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.hibernate_advanced_demo.dao.AppDao;
import com.spring.hibernate_advanced_demo.entity.Course;
import com.spring.hibernate_advanced_demo.entity.Instructor;
import com.spring.hibernate_advanced_demo.entity.InstructorDetail;
import com.spring.hibernate_advanced_demo.entity.Review;
import com.spring.hibernate_advanced_demo.entity.Student;

@SpringBootApplication
public class HibernateAdvancedDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(HibernateAdvancedDemoApplication.class, args);
  }

  // ========= 1st =========
  // @Bean
  // CommandLineRunner commandLineRunner(String[] args) {
  // return runner -> {
  // System.out.println("Hello World");
  // };
  // }

  @Bean
  CommandLineRunner commandLineRunner(AppDao app) {
    return runner -> {
      // createInstructor(app);
      // findInstructor(app);
      // deleteInstructor(app);
      // findInstructorDetail(app);
      // deleteInstructorDetail(app);
      // createInstructorWithCourses(app);
      // findInstructorWithCourses(app);
      // findCoursesForInstructor(app);
      // findInstructorWithCoursesJoinFetch(app);
      // updateInstructor(app);
      // deleteInstructorOnly(app);
      // createCourseAndReviews(app);
      // retrieveCourseAndReviews(app);
      // deleteCourseAndReviews(app);
      // createCourseAndStudents(app);
      // findCourseAndStudents(app);
      // findStudentsAndCourses(app);
      // addMoreCoursesForStudent(app);
      // deleteCourseById(app);
      deleteStudent(app);
    };
  }

  // Create
  private void createInstructor(AppDao app) {
    Instructor ins = new Instructor("Vicky", "Magtangol", "vicky.mags@example.com");
    InstructorDetail deets = new InstructorDetail("Math", "Solving Problems");

    ins.setInstructorDeets(deets);

    System.out.println("Information Saved!");
    app.save(ins);

  }

  // Find
  private void findInstructor(AppDao app) {
    int id = 1;
    System.out.println("Find ID: " + id);

    Instructor ins = app.findInstructorById(id);

    System.out.println("Instructor: " + ins);
    System.out.println("Details: " + ins.getInstructorDeets());
  }

  // Delete - Instructor
  private void deleteInstructor(AppDao app) {
    int id = 1;
    System.out.println("Deleted ID:" + id);

    app.deleteInstructorId(id);
    System.out.println("Deleted Successfully!");
  }

  // Query
  private void findInstructorDetail(AppDao app) {
    int id = 3;
    InstructorDetail inDeets = app.findInstructorDetailById(id);

    System.out.println("Details: " + inDeets);

    System.out.println("Instructor: " + inDeets.getInstructor());
  }

  // Delete - Instructor Detail
  private void deleteInstructorDetail(AppDao app) {
    int id = 3;
    System.out.println("Deleted ID:" + id);

    app.deleteInstructorDetail(id);
    System.out.println("Deleted Successfully!");
  }

  // Create Instructor with Courses
  private void createInstructorWithCourses(AppDao app) {
    Instructor ins = new Instructor("Peri", "Winkle", "peri.winkle@example.com");
    InstructorDetail deets = new InstructorDetail("Science", "Sprinkling Dust");

    ins.setInstructorDeets(deets);

    Course course1 = new Course("Physics");
    Course course2 = new Course("Biology");

    ins.add(course1);
    ins.add(course2);

    System.out.println("Courses saved: " + ins.getCourses());
    app.save(ins);

  }

  // Query - Instructor w/ course
  private void findInstructorWithCourses(AppDao app) {
    int id = 4;
    System.out.println("Find instructor ID: " + id);

    Instructor ins = app.findInstructorById(id);

    System.out.println("Instructor: " + ins);
    System.out.println("Courses; " + ins.getCourses());
  }

  // Query - Courses for Instructor
  private void findCoursesForInstructor(AppDao app) {
    int id = 4;
    System.out.println("Find instructor ID: " + id);
    Instructor ins = app.findInstructorById(id);

    System.out.println("Instructor: " + ins);

    System.out.println("Courses from ID: " + id);
    List<Course> courses = app.findCoursesByInstructorId(id);

    ins.setCourses(courses);
    System.out.println(ins.getCourses());

  }

  // Query - Instructor with Courses (Join Fetch)
  private void findInstructorWithCoursesJoinFetch(AppDao app) {
    int id = 4;
    System.out.println("Find instructor ID: " + id);

    Instructor ins = app.findInstructorByIdJoinFetch(id);

    System.out.println("Instructor: " + ins);
    System.out.println("Courses: " + ins.getCourses());
  }

  // Update Instructor
  private void updateInstructor(AppDao app) {
    int id = 3;
    System.out.println("Find instructor ID: " + id);

    Instructor ins = app.findInstructorById(id);

    ins.setLastName("Cosma");

    System.out.println("Updated!");
    app.update(ins);
  }

  // Delete Instructor Only
  private void deleteInstructorOnly(AppDao app) {
    int id = 3;
    System.out.println("Delete instructor: " + id);

    app.deleteInstructorById(id);
    System.out.println("Deleted Successfully!");
  }

  // Create Course and Reviews
  private void createCourseAndReviews(AppDao app) {
    Course course = new Course("How to Speedrun Spring in 1 Day!");
    course.addReview(new Review("Great Speed 2x ... loved it!!!"));
    course.addReview(new Review("I wanted the speed 0.75x :((("));
    course.addReview(new Review("Hoping to blablablablalbknasdkgn"));

    System.out.println("Course Saved!");
    app.save(course);

  }

  // Fetch Reviews and Comments
  private void retrieveCourseAndReviews(AppDao app) {
    int id = 3;
    System.out.println("Get Course and review from ID: " + id);
    Course course = app.findCourseAndReviewsByCourseId(id);

    System.out.println(course);
    System.out.println(course.getReview());
  }

  // Delete Course and Reviews
  private void deleteCourseAndReviews(AppDao app) {
    int id = 3;
    System.out.println("Delete course: " + id);

    app.deleteCourseById(id);
    System.out.println("Deleted successfully!");
  }

  // Create Course and Students
  private void createCourseAndStudents(AppDao app) {
    Course course = new Course("How to be a Full Stack dev in half a day.");
    Student student1 = new Student("Light", "Yagami", "light.yagami@example.com");
    Student student2 = new Student("Leslie", "Andrews", "leslie.andrews@example.com");

    course.addStudent(student1);
    course.addStudent(student2);

    app.save(course);
    System.out.println("Successfully Enrolled");

  }

  // Query Students via Courses
  private void findCourseAndStudents(AppDao app) {
    int id = 4;
    Course course = app.findCourseAndStudentByCourseId(id);

    System.out.println("Course: " + course);
    System.out.println("Students: " + course.getStudents());
  }

  // Query Courses via Students
  private void findStudentsAndCourses(AppDao app) {
    int id = 2;
    Student student = app.findStudentAndCoursesByStudentId(id);

    System.out.println("Student: " + student);
    System.out.println("Courses: " + student.getCourses());
  }

  // Update Student(?)
  private void addMoreCoursesForStudent(AppDao app) {
    int id = 2;
    Student student = app.findStudentAndCoursesByStudentId(id);

    Course course1 = new Course("How to test without running application");
    Course course2 = new Course("How to develop without computer");
    Course course3 = new Course("How to be a legit developer");

    student.addCourse(course1);
    student.addCourse(course2);
    student.addCourse(course3);

    System.out.println("Successfully Enrolled to the new courses!");

    app.update(student);
  }

  //Delete Course
  private void deleteCourseById(AppDao app){
    int id = 5;
    System.out.println("Deleted Course: " + id);

    app.deleteCourseById(id);
    System.out.println("Deleted Successfully!");
  }

  //Delete Student
  private void deleteStudent(AppDao app){
    int id = 1;
    System.out.println("Delete Student: " + id);
    
    app.deleteStudentById(id);
    System.out.println("Deleted Successfully!");
  }
}
