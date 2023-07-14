package com.example.collection.controller;

import com.example.collection.dto.response.BaseResponse;
import com.example.collection.service.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
public class ClassStudentController {
    private final ClassService classService;

    public ClassStudentController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping("/get-all")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "") String name) {
        return new ResponseEntity<>(new BaseResponse<>(classService.getClass(name)), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createClass(@RequestBody String request) {
        return new ResponseEntity<>(classService.createClass(request), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateClass(@RequestBody String request) {
        return new ResponseEntity<>(classService.updateClass(request), HttpStatus.OK);
    }

    @GetMapping("/get-detail/{id}")
    public ResponseEntity<?> getDetail(@PathVariable String id) {
        return new ResponseEntity<>(new BaseResponse<>(classService.getDetail(id)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@RequestParam String id) {
        classService.delete(id);
        return new ResponseEntity<>(new BaseResponse<>(), HttpStatus.OK);
    }
}
