package com.project.sms.service;

import com.project.sms.dto.request.StudentRequest;
import com.project.sms.dto.response.StudentResponse;

public interface StudentService {
    StudentResponse createStudent(StudentRequest request);

    StudentResponse updateStudent(Integer enrollmentNo, StudentRequest request);

    StudentResponse getStudentById(Integer enrollmentNo);

    void deleteStudent(Integer enrollmentNo);
}
