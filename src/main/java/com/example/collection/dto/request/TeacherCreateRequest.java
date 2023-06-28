package com.example.collection.dto.request;

import lombok.Data;

@Data
public class TeacherCreateRequest {

    private String teacherName;
    private String teacherEmail;
    private String teacherAddress;
    private String gender;
    private Integer age;
    private Double salary;
    private String subject;
    private String classManager;
    private String userName;
    private String password;
}
