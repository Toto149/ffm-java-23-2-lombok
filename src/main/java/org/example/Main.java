package org.example;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

/*

    Step 1: Add the Lombok dependency to your project and configure IntelliJ to support Lombok.

    Step 2: Create a simple class "Student" with the following attributes: id, name, address, grade.

    Step 2.5: Use the appropriate Lombok annotations to generate getters, setters, equals, hashCode, toString, and constructors for the entity.

    Step 3: Create a Teacher record with the following attributes: id, name, subject.

    Step 4: Create a class Course with the following attributes: id, name, teacher, students.

    Step 4.5: Use the appropriate Lombok annotations to generate getters, setters, equals, hashCode, toString, and constructors for the entity.

    Step 5: Write a "Main" class where you apply some examples of creating Students, Teachers, and Courses using the constructors.

    Step 6: In the "Main" class, check if the generated Lombok methods work correctly (getter, setter, toString, ...).


 */
public class Main {
    public static void main(String[] args) {
       Teacher teacher = new Teacher("1234","Michael Mustermann", "Wirtschaft");
        teacher = teacher.withName("Maria Musterfrau");
        Student student = new Student("23563", "Galois", "Musterer Straße 30, Musterhausen", 1.0);
       Student student2 = new Student("33234", "John Doe", "Musterstraße 20, Musterstadt ", 3.0);
        List<Student> studentList = List.of(student,student2);
        Course course = new Course("101", "Wirtschaftslehre", teacher, studentList);
        Student student3 = Student.builder()
                .id("26354")
                .name("Martin Mustermann")
                .address("Musterstraße 42, 42424 Musterstadt")
                .grade(1.0)
                .build();
        Course course2 = new Course("202", "Mathematik", teacher,List.of(student3));
        List<Course> listCourse = List.of(course,course2);

     System.out.println("============= Prints um die Funktionalität der Annotations von Lombok zu testen");
     System.out.println(course.getStudents());
        System.out.println(course.getTeacher());
        System.out.println(course.getTeacher().name());
        System.out.println(course.getStudents().get(0));
        System.out.println(student3);
     System.out.println(teacher);
        System.out.println();
        System.out.println();



        University university = new University("113154252", "Universität Münster", listCourse);
        UniversityService universityService = new UniversityService(university);
        System.out.println("========Bonus Aufgabe");
        System.out.println("Die Durchschnittsnote der Studenten des Kurses 1 ist: " + universityService.courseGradeAverage(course));
        System.out.println("Die Durschnittsnote aller Kurse der Universität ist: "+ universityService.universityGradeAverage(university));
        System.out.println("Die Liste der Studenten mit Note besser als 2 ist: " + universityService.goodStudents(university));

    }
}