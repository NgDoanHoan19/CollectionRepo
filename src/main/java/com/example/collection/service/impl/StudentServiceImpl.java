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

import java.io.IOException;
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
            if (studentRepository.existsById(request.getStudentId())) {
                return new ServerException(ApiCode.DUPLICATE_ID_STUDENT);
            }
        }
        Student student = new Student();
        saveToStudent(request, student);
        return new BaseResponse(ApiCode.SUCCESS, student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object UpdateStudent(StudentCreateRequest request) {
        Optional<Student> student = studentRepository.findById(request.getStudentId());
        if (!student.isPresent()) {
            return new ServerException(ApiCode.STUDENT_NOT_FOUND);
        }
        Student studentUpdate = student.get();
        saveToStudent(request, studentUpdate);
        return new BaseResponse(ApiCode.SUCCESS, studentUpdate);
    }

    @Override
    public Object findStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ServerException(ApiCode.NOT_FOUND));
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ServerException(ApiCode.NOT_FOUND));
        studentRepository.delete(student);
    }

    private void saveToStudent(StudentCreateRequest request, Student student) {
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
    }
}
