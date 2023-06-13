package com.example.collection.service;

import com.example.collection.dto.request.EmployeeCreateRequest;

import java.util.List;

public interface EmployeeService {
    Object getAll();
    Object saveEmployee(EmployeeCreateRequest request);
    Object UpdateEmployee(EmployeeCreateRequest request);
    void deleteEmployee(Long id);
}
