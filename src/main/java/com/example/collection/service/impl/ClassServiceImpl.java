package com.example.collection.service.impl;

import com.example.collection.repository.ClassRepository;
import com.example.collection.service.ClassService;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Object getClass(String name) {
        return null;
    }

    @Override
    public Object createClass(String request) {
        return null;
    }

    @Override
    public Object updateClass(String request) {
        return null;
    }

    @Override
    public Object getDetail(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
