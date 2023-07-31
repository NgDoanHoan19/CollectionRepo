package com.example.collection.service.impl;

import com.example.collection.constain.ApiCode;
import com.example.collection.dto.request.GetAllStudentRequest;
import com.example.collection.dto.request.StudentCreateRequest;
import com.example.collection.dto.response.BaseResponse;
import com.example.collection.entities.Student;
import com.example.collection.exception.ServerException;
import com.example.collection.repository.StudentRepository;
import com.example.collection.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Object getAll(GetAllStudentRequest request) {
        String name = Objects.nonNull(request.getName()) ? request.getName() : "";
        int pageNum = Objects.nonNull(request.getPageNum()) ? request.getPageNum() : 0;
        int pageSize = Objects.nonNull(request.getPageSize()) ? request.getPageSize() : 10;
        String sortField = Objects.nonNull(request.getSortField()) ? request.getSortField() : "id";
        String sortDirection = Objects.nonNull(request.getSortDirection()) ? request.getSortDirection() : "desc";
        Sort sort = Sort.by(sortField);
        if ("desc".equals(sortDirection)) {
            sort = sort.descending();
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        return studentRepository.getAll(name.toLowerCase(), pageable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object saveStudent(StudentCreateRequest request) {
        Student student = new Student();
        saveToStudent(request, student);
        return new BaseResponse<>(ApiCode.SUCCESS, student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object updateStudent(StudentCreateRequest request) {
        Optional<Student> student = studentRepository.findById(request.getStudentId());
        if (student.isEmpty()) {
            return new ServerException(ApiCode.STUDENT_NOT_FOUND);
        }
        Student studentUpdate = student.get();
        saveToStudent(request, studentUpdate);
        return new BaseResponse<>(ApiCode.SUCCESS, studentUpdate);
    }

    @Override
    public Object findStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ServerException(ApiCode.STUDENT_NOT_FOUND));
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ServerException(ApiCode.STUDENT_NOT_FOUND));
        studentRepository.delete(student);
    }

    public void saveToStudent(StudentCreateRequest request, Student student) {
        if (validate(request)) {
            student.setFullName(request.getFullName());
            student.setStudentEmail(request.getStudentEmail());
            student.setClassId(request.getClassId());
            student.setStudentAddress(request.getStudentAddress());
            student.setGender(request.getGender());
            student.setAge(request.getAge());
            student.setCpa(request.getCpa());
            student.setUserName(request.getUserName());
            student.setPassword(request.getPassword());
            studentRepository.save(student);
        } else {
            throw new ServerException(ApiCode.FAIL);
        }
    }

    public boolean validate(StudentCreateRequest request) {
        if (!("nam".equals(request.getGender()) || "nu".equals(request.getGender()))) {
            throw new ServerException(ApiCode.VALIDATE_GENDER);
        }
        if (request.getAge() < 0 || request.getAge() > 100) {
            throw new ServerException(ApiCode.VALIDATE_AGE);
        }
        if (request.getCpa() < 0.0 || request.getCpa() > 4.0) {
            throw new ServerException(ApiCode.VALIDATE_CPA);
        }
        return true;
    }
}
