package com.example.collection.service;

import com.example.collection.dto.request.GetAllStudentRequest;
import com.example.collection.dto.request.StudentCreateRequest;

import java.io.IOException;


public interface StudentService {
    Object getAll(GetAllStudentRequest request);

    Object saveStudent(StudentCreateRequest request);

    Object updateStudent(StudentCreateRequest request);

    Object findStudentById(Long id);

    void deleteStudent(Long id);
}
