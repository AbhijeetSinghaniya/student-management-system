package com.project.sms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.sms.dto.request.StudentSubjectRequest;
import com.project.sms.service.StudentSubjectService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/student-subject")
@RequiredArgsConstructor
public class StudentSubjectController {
    private final StudentSubjectService studentSubjectService;

    @PostMapping("/assign")
    @ResponseStatus(HttpStatus.CREATED)
    public void assignSubject(@Valid @RequestBody StudentSubjectRequest request) {
        studentSubjectService.assignSubjectToStudent(request);
    }

    @PostMapping("/unassign")
    public ResponseEntity<String> unassignSubject(@Valid @RequestBody StudentSubjectRequest request) {
        studentSubjectService.unassignSubject(request);
        return ResponseEntity.ok("Subject unassigned successfully");
    }
}
