package com.example.collection.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "class_student")
public class ClassStudent {
    @Id
    @Column(name = "class_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String classId;

    @Column(name = "class_name")
    private String className;
}
