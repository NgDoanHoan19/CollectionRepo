package com.example.collection.repository;

import com.example.collection.dto.StudentDto;
import com.example.collection.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFullNameContaining(String name);

//    @Query("SELECT s FROM Student s " +
//            "   WHERE (:name = '' OR lower(s.fullName) like CONCAT('%', :name, '%')) ")
////    @Query(value = "SELECT * FROM Student s " +
////                        "   WHERE (:name = '' OR lower(s.student_name) like CONCAT('%' , :name ,'%'))",
////            nativeQuery = true)


    @Query(value = "select s.id as studentId," +
            "s.student_name as fullName," +
            "s.age as age," +
            "s.gender as gender," +
            "s.address as studentAddress," +
            "s.email as studentEmail," +
            "s.cpa as cpa," +
            "cs.class_name as className," +
            "t.teacher_name as teacherName " +
            "from university.student s " +
            "left join university.class_student cs on s.class_id = cs.class_id " +
            "left join university.teacher t on s.class_id  = t.class_manager_id " +
            "where (:name '' or lower(s.student_name) like concat('%', :name, '%'))" +
            "group by s.id,t.teacher_name ",
                        nativeQuery = true)
    Page<StudentDto> getAll(String name, Pageable pageable);
}
