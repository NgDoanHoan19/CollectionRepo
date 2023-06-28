package com.example.collection.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String studentEmail;

    @Column(name = "address")
    private String studentAddress;

    @Column(name = "cpa")
    private Double cpa;

    @Column(name = "class_student")
    private String classStudent;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

}
