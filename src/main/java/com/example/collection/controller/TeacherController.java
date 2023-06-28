package com.example.collection.controller;

import com.example.collection.dto.request.TeacherCreateRequest;
import com.example.collection.dto.response.BaseResponse;
import com.example.collection.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllTeacher(@RequestParam(defaultValue = "") String name) {
        return new ResponseEntity(new BaseResponse<>(teacherService.getTeacher(name)), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TeacherCreateRequest request) {
        return new ResponseEntity<>(teacherService.createTeacher(request), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody TeacherCreateRequest request) {
        return new ResponseEntity<>(teacherService.updateTeacher(request), HttpStatus.OK);
    }

    @GetMapping("/get-detail/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        return new ResponseEntity<>(new BaseResponse<>(teacherService.getDetail(id)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(new BaseResponse<>(), HttpStatus.OK);
    }
}
