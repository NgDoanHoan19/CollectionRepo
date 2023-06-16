package com.example.collection.dto.request;

import lombok.Data;

@Data
public class StudentCreateRequest {
    private Long studentId;
    private String studentName;
    private String gender;
    private Integer age;
    private String studentEmail;
    private String studentAddress;
    private Double cpa;
    private String classStudent;
    private String password;

}
