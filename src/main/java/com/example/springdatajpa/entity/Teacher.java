package com.example.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"

    )
    private Long teacherId;
    private String firstName;
    private String lastName;

    /**@desc One to many relationship between teacher and course,teacher can teach many courses
     * we create a join column in the courses table and place the ids of the teachers*/
  /*  @OneToMany(
            cascade = CascadeType.ALL

    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private List<Course> courses;*/
}
