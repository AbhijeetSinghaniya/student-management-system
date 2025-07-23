package com.project.sms.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sms.dto.request.StudentRequest;
import com.project.sms.dto.response.StudentResponse;
import com.project.sms.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public StudentResponse createStudent(@Valid @RequestBody StudentRequest studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @PostMapping("/update/{id}")
    public StudentResponse updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentRequest studentDTO) {
        return studentService.updateStudent(id, studentDTO);
    }

    @GetMapping("/fetch/{id}")
    public StudentResponse getStudent(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}
