package com.example.collection.repository;

import com.example.collection.entities.ClassStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassStudent, Long> {
}
