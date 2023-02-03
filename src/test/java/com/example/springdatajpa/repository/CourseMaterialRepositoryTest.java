package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.CourseMaterial;
import com.example.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseMaterial() {
        Course course =
                Course.builder()
                        .title(".NET")
                        .credit(6)
                        .build();
        /**@desc test fails because we are trying to save a course material and referencing to a course that doesn't exist
         * @Todo cascading will save the situation*/
        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.dailycodebuffer.com")
                       .course(course)
                        .build();
        repository.save(courseMaterial);
    }

    @Test
    public  void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials =
                repository.findAll();

        System.out.println("CourseMaterials = " + courseMaterials);
    }


}