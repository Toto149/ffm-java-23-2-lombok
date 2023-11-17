package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class UniversityService {
    private University university;

    public double courseGradeAverage (Course course){
        return university.courses()
                .stream()
                .filter(course1 -> course1.equals(course))
                .findFirst()
                .map(Course::getStudents)
                .stream()
                .flatMap(List::stream)
                .map(student -> student.getGrade())
                .reduce(0.0, (x,y) -> (x+y)/course.getStudents().size());
    }
    public double universityGradeAverage(University university){
        return university.courses()
                .stream()
                .map(this::courseGradeAverage)
                .reduce((double) 0,(x, y) -> (x+y)/university.courses().size());
    }
    public List<Student> goodStudents(University university){
        return university.courses().stream()
                .map(course -> course.getStudents())
                .flatMap(List::stream)
                .collect(Collectors.toSet())
                .stream()
                .collect(Collectors.toList())
                .stream().filter(student -> student.getGrade()<=2.0)
                .collect(Collectors.toList());

    }
}
