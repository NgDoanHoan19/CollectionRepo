package com.example.collection.service.impl;


import com.example.collection.dto.request.TeacherCreateRequest;
import com.example.collection.repository.TeacherRepository;
import com.example.collection.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Object getTeacher(String name) {
        return teacherRepository.findByTeacherNameContaining(name);
    }

    @Override
    public Object createTeacher(TeacherCreateRequest request) {
        return null;
    }

    @Override
    public Object updateTeacher(TeacherCreateRequest request) {
        return null;
    }

    @Override
    public Object getDetail(Integer id) {
        return null;
    }

    @Override
    public void deleteTeacher(Integer id) {

    }
}
