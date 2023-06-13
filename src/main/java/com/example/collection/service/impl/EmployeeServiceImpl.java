package com.example.collection.service.impl;

import com.example.collection.dto.request.EmployeeCreateRequest;
import com.example.collection.repository.EmployeeRepository;
import com.example.collection.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Object getAll() {
        return null;
    }

    @Override
    public Object saveEmployee(EmployeeCreateRequest request) {
        return null;
    }

    @Override
    public Object UpdateEmployee(EmployeeCreateRequest request) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }
}
