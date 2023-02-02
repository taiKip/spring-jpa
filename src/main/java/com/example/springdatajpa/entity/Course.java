package com.example.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;


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

}
