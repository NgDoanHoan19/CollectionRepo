package com.example.collection.service.impl;

import com.example.collection.dto.request.StudentCreateRequest;
import com.example.collection.repository.StudentRepository;
import com.example.collection.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Object getAll() {
        return null;
    }

    @Override
    public Object saveStudent(StudentCreateRequest request) {
        return null;
    }

    @Override
    public Object UpdateStudent(StudentCreateRequest request) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
