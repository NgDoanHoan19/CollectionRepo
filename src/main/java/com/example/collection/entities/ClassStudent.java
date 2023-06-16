package com.example.collection.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "class_student")
public class ClassStudent {
    @Id
    @Column(name = "class_id")
    private Long classId;

    @Column(name = "class_name")
    private String className;
}
