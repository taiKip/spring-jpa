package com.example.springdatajpa.service;

import com.example.springdatajpa.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    Student saveStudent(Student student);
}
