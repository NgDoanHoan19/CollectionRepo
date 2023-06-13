package com.example.collection.service;

import com.example.collection.dto.request.StudentCreateRequest;


public interface StudentService {
    Object getAll();
    Object saveStudent(StudentCreateRequest request);
    Object UpdateStudent(StudentCreateRequest request);
    void deleteStudent(Long id);
}
