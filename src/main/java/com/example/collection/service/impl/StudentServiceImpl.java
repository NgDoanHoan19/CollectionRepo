package com.example.collection.service.impl;

import com.example.collection.dto.request.StudentCreateRequest;
import com.example.collection.entities.Student;
import com.example.collection.repository.StudentRepository;
import com.example.collection.service.StudentService;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Object getAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object saveStudent(StudentCreateRequest request) {
        if(!StringUtils.isEmpty(request.getStudentId())){
            if(studentRepository.findById(request.getStudentId()).isPresent()){
                return null;
            }
        }
        Student student = new Student();
        student.setStudentId(request.getStudentId());
        student.setStudentName(request.getStudentName());
        student.setStudentEmail(request.getStudentEmail());
        student.setClassStudent(request.getClassStudent());
        student.setStudentAddress(request.getStudentAddress());
        student.setGender(request.getGender());
        student.setAge(request.getAge());
        student.setCpa(request.getCpa());
        student.setUserName(request.getUserName());
        student.setPassword(request.getPassword());
        studentRepository.save(student);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @Override
    public Object UpdateStudent(StudentCreateRequest request) {
        return null;
    }

    @Override
    public Object findStudentById(Long id) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
