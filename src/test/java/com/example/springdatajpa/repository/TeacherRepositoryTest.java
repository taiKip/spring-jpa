package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseBBA = Course.builder().title("BBA").credit(5).build();
        Course courseDBA = Course.builder().title("DBA").credit(6).build();
        Course courseJAVA = Course.builder().title("Java").credit(5).build();
        Teacher teacher = Teacher
                .builder()
                .firstName("Khan")
                .lastName("Smith")
              //  .courses(List.of(courseDBA,courseDBA))
                .build();
        teacherRepository.save(teacher);
    }


}