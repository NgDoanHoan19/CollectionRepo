package com.example.collection.service.impl;

import com.example.collection.constain.ApiCode;
import com.example.collection.dto.request.StudentCreateRequest;
import com.example.collection.dto.response.BaseResponse;
import com.example.collection.entities.Student;
import com.example.collection.exception.ServerException;
import com.example.collection.repository.StudentRepository;
import com.example.collection.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

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
        if (Objects.nonNull(request.getStudentId())) {
            studentRepository.findById(request.getStudentId()).ifPresent(student -> {
                throw new ServerException(ApiCode.DUPLICATE_ID_STUDENT);
            });
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
        return new BaseResponse(ApiCode.SUCCESS, student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object UpdateStudent(StudentCreateRequest request) {
        Optional<Student> student = studentRepository.findById(request.getStudentId());
        if(!student.isPresent()){
            return new ServerException(ApiCode.STUDENT_NOT_FOUND);
        }
        Student student1 = new Student();
        student1.setStudentName(request.getStudentName());
        student1.setStudentEmail(request.getStudentEmail());
        student1.setClassStudent(request.getClassStudent());
        student1.setStudentAddress(request.getStudentAddress());
        student1.setGender(request.getGender());
        student1.setAge(request.getAge());
        student1.setCpa(request.getCpa());
        student1.setUserName(request.getUserName());
        student1.setPassword(request.getPassword());
        studentRepository.save(student1);
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
