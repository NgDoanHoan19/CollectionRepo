package com.example.collection.service;

import com.example.collection.dto.request.StudentCreateRequest;


public interface StudentService {
    Object getAll();
    Object saveStudent(StudentCreateRequest request);
    Object UpdateStudent(StudentCreateRequest request);
    Object findStudentById(Long id);
    void deleteStudent(Long id);
}
