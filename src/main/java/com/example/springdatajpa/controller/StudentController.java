package com.example.springdatajpa.controller;

import com.example.springdatajpa.entity.Student;
import com.example.springdatajpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public Student saveStudent(@RequestBody  Student student){
        return  studentService.saveStudent(student);
    }

}
