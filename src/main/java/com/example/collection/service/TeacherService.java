package com.example.collection.service;

import com.example.collection.dto.request.TeacherCreateRequest;

public interface TeacherService {
    Object getTeacher(String name);

    Object createTeacher(TeacherCreateRequest request);

    Object updateTeacher(TeacherCreateRequest request);

    Object getDetail(Integer id);

    void deleteTeacher(Integer id);
}
