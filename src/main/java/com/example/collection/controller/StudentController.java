package com.example.collection.controller;


import com.example.collection.dto.request.StudentCreateRequest;
import com.example.collection.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(studentService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(StudentCreateRequest request) {
        return new ResponseEntity(studentService.saveStudent(request), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateStudent(StudentCreateRequest request) {
        return new ResponseEntity<>(studentService.UpdateStudent(request), HttpStatus.OK);
    }

    @GetMapping("get-detail")
    public ResponseEntity<?> getDetail(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
