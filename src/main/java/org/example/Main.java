package org.example;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;


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
        System.out.println("========Bonus Aufgabe");
        System.out.println("Die Durchschnittsnote der Studenten des Kurses 1 ist: " + UniversityService.courseGradeAverage(course));
        System.out.println("Die Durschnittsnote aller Kurse der Universität ist: "+ UniversityService.universityGradeAverage(university));
        System.out.println("Die Liste der Studenten mit Note besser als 2 ist: " + UniversityService.goodStudents(university));

    }
}