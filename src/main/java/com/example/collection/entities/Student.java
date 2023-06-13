package com.example.collection.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "employee")
public class Student {
    @Id
    @Column(name = "id")
    private Long employee_id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String employeeEmail;

    @Column(name = "address")
    private String employeeAddress;

    @Column(name = "password")
    private String password;

}
