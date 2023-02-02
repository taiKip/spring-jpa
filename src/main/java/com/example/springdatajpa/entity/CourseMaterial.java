package com.example.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    /**@desc Fetch : how you want to fetch the data
     * -@Fetch Types :
     * when having a relationship between two entities and you want to fetch data do you want to just fetch for a single table or all
     * - Eager will bring data for course  also when you fetch for the course material;
     * -Lazy  will bring only data for the course material unless you specifically ask to fetch for the coures
     * -*/
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn( /**@desc which particular column we  can join these two tables*/
            name = "course_id",/**@desc name of column should be course_id, course material table will have an extra column ie course_id which
    will tell use to which course this material belongs*/
            referencedColumnName = "courseId"
    )
@ToString.Exclude
    private Course course;
}
