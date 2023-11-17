package org.example;

import lombok.*;

import java.util.List;
@Value
@Builder
@AllArgsConstructor
public class Course {
    private String id;
    private String name;
    private Teacher teacher;
    private List<Student> students;
}
