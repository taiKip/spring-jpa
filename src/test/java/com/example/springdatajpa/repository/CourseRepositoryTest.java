package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.sql.SQLOutput;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses =
                courseRepository.findAll();

        System.out.println("course " + courses);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher
                .builder()
                .firstName("Priyanka")
                .lastName("Chopra")
                .build();
        Course course = Course
                .builder()
                .title("Python")
                .credit(6).teacher(teacher).build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3); //my page should have three records, if total number of elements is 5,the total pages will be two
        Pageable secondPageWithTwoRecords =
                PageRequest.of(0,2);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords).getContent();
        List<Course> courses1 =
                courseRepository.findAll(secondPageWithTwoRecords).getContent();
long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("Total elements = " + totalElements);
        System.out.println("courses = " + courses1);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(0,2, Sort.by("title").ascending());

        Pageable sortByCreditDesc =
                PageRequest.of(0,2,Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title").descending().and(Sort.by("credit"))
                );

        List<Course> courses
                = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Courses = " + courses);
    }
    @Test
    public void printFindByTitleContaining(){
Pageable firstPageTenRecords = PageRequest.of(0,10); //first page 10 rows

List<Course> courses =
        courseRepository.findByTitleContaining("D",firstPageTenRecords).getContent();

        System.out.println("Courses = " + courses);
    }
}