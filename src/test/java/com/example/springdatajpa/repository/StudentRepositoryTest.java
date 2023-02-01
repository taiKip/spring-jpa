package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Guardian;
import com.example.springdatajpa.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student =
                Student.builder()
                        .email("vick@gmail.com")
                        .firstName("vick")
                        .lastName("tarus")
                     //   .guardianEmail("gab@gmail.com")
                       // .guardianMobile("1332523")
                     //   .guardianName("gabriel")
                        .build();

        studentRepository.save(student);
    }

    @Test
    public  void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("gab@test.com")
                .mobile("17373492373")
                .name("gabriel").build();
        Student student = Student.builder()
                .firstName("vick")
                .lastName("Tarus")
                .email("vick@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public  void fetchAllStudents(){
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println("Student List" + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =studentRepository.findByFirstName("vick");
        System.out.println("Students = " + students);
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =studentRepository.findByFirstNameContaining("ck");
        System.out.println("Students = " + students);
    }

@Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students  = studentRepository.findByGuardianName("gabriel");
    System.out.println("Students = " + students);
}

@Test
    public void getStudentByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastNameIgnoreCase("vick","tarus");
    System.out.println("Student = "  + student);
}
}