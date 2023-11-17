package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UniversityService {

    public static double courseGradeAverage(Course course){
        return course.getStudents()
                .stream()
                .map(Student::getGrade)
                .reduce(0.0,(x,y)-> x+y)/course.getStudents().size();
    }
    public static double universityGradeAverage(University university){
        int amountOfStudents = university.courses().stream().map(course -> course.getStudents().size()).reduce(0,(x,y) -> x+y);
        return university.courses()
                .stream()
                .map(Course::getStudents)
                .flatMap(List::stream)
                .collect(Collectors.toSet())
                .stream()
                .map(Student::getGrade)
                .reduce((double) 0,(x, y) -> (x+y))/amountOfStudents;
    }
    public static List<Student> goodStudents(University university){
        return university.courses().stream()
                .map(Course::getStudents)
                .flatMap(List::stream)
                .collect(Collectors.toSet())
                .stream()
                .collect(Collectors.toList())
                .stream().filter(student -> student.getGrade()<=2.0)
                .collect(Collectors.toList());

    }
}
