package com.example.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Entity
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;
    /**@desc We can not define a join column because we already defined it in the course material class.
    this particular one to one mapping has been defined with the course attribute in the course material*/
    /**@desc we need a reference of course material to enable us to fetch it when fetching course.*/
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;
@ManyToOne(
        cascade = CascadeType.ALL
)
@JoinColumn(
        name ="teacher_id",
        referencedColumnName = "teacherId"
)
    private Teacher teacher;

@ManyToMany
@JoinTable( /**@desc create new table and the two columns that need to be referred*/
        name ="student_course_map",
        joinColumns = @JoinColumn(
                name="course_id",
                referencedColumnName = "courseId"
        ),
        inverseJoinColumns = @JoinColumn(
                name = "student_id",
                referencedColumnName = "studentId"
        )
)
private List<Student> students;
public void addStudents (Student student){
    if(students == null) students = new ArrayList<>();
    students.add(student);
}
}
