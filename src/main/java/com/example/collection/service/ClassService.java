package com.example.collection.service;

public interface ClassService {
    Object getClass(String name);
    Object createClass(String request);
    Object updateClass(String request);
    Object getDetail(String id);
    void delete(String id);
}
