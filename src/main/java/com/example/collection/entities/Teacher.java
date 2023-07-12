package com.example.collection.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Integer teacherID;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_email")
    private String teacherEmail;

    @Column(name = "teacher_address")
    private String teacherAddress;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "subject")
    private String subject;

    @Column(name = "class_manager_id")
    private Integer classManagerID;

    @Column(name = "User_name")
    private String userName;

    @Column(name = "pass_word")
    private String password;
}
