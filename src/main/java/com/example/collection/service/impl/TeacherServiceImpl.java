package com.example.collection.service.impl;


import com.example.collection.constain.ApiCode;
import com.example.collection.dto.request.TeacherCreateRequest;
import com.example.collection.dto.response.BaseResponse;
import com.example.collection.entities.Teacher;
import com.example.collection.exception.ServerException;
import com.example.collection.repository.TeacherRepository;
import com.example.collection.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Object getTeacher(String name) {
        List<Teacher> teacherList = teacherRepository.findByTeacherNameContaining(name);
        return teacherList.stream().filter(teacher -> teacher.getSalary() > 150 && teacher.getAge() < 40).sorted().collect(Collectors.toList());
    }

    @Override
    public Object createTeacher(TeacherCreateRequest request) {
        if (Objects.isNull(request)) {
            throw new ServerException(ApiCode.NOT_FOUND);
        }
        Teacher teacher = new Teacher();
        saveTeacher(request, teacher);
        return new BaseResponse<>(ApiCode.SUCCESS, teacher);
    }

    @Override
    public Object updateTeacher(TeacherCreateRequest request) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(request.getTeacherId());
        if (teacherOptional.isEmpty()) {
            return new ServerException(ApiCode.TEACHER_NOT_FOUND);
        }
        Teacher teacher = teacherOptional.get();
        saveTeacher(request, teacher);
        return new BaseResponse<>(ApiCode.SUCCESS, teacher);
    }

    @Override
    public Object getDetail(Integer id) {
        return teacherRepository.findById(id).orElseThrow(() -> new ServerException(ApiCode.TEACHER_NOT_FOUND));
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherRepository.delete(teacherRepository.findById(id).orElseThrow(() -> new ServerException(ApiCode.TEACHER_NOT_FOUND)));
    }

    public void saveTeacher(TeacherCreateRequest request, Teacher teacher) {
        if (validateRequest(request)) {
            teacher.setTeacherName(request.getTeacherName());
            teacher.setAge(request.getAge());
            teacher.setGender(request.getGender());
            teacher.setTeacherAddress(request.getTeacherAddress());
            teacher.setTeacherEmail(request.getTeacherEmail());
            teacher.setClassManagerID(request.getClassManagerId());
            teacher.setSubject(request.getSubject());
            teacher.setSalary(request.getSalary());
            teacher.setUserName(request.getUserName());
            teacher.setPassword(request.getPassword());
            teacherRepository.save(teacher);
        } else {
            throw new ServerException(ApiCode.FAIL);
        }
    }

    public boolean validateRequest(TeacherCreateRequest request) {
        if (!("nam".equals(request.getGender()) || "nu".equals(request.getGender()))) {
            throw new ServerException(ApiCode.VALIDATE_GENDER);
        }
        if (Objects.isNull(request.getAge()) || request.getAge() < 0 || request.getAge() > 100) {
            throw new ServerException(ApiCode.VALIDATE_AGE);
        }
        if (request.getSalary() < 0) {
            throw new ServerException(ApiCode.VALIDATE_SALARY);
        }
        return true;
    }
}
