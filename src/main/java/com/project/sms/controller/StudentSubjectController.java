package com.project.sms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.sms.dto.request.AssignSubjectRequest;
import com.project.sms.service.StudentSubjectService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/assign")
@RequiredArgsConstructor
public class StudentSubjectController {
    private final StudentSubjectService studentSubjectService;

    @PostMapping("/subject")
    @ResponseStatus(HttpStatus.CREATED)
    public void assignSubject(@Valid @RequestBody AssignSubjectRequest request) {
        studentSubjectService.assignSubjectToStudent(request);
    }
}
