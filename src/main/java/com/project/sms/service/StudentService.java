package com.project.sms.service;

import java.util.List;

import com.project.sms.dto.request.StudentRequest;
import com.project.sms.dto.response.StudentResponse;
import com.project.sms.dto.response.StudentWithSubjectResponse;

public interface StudentService {
    StudentResponse createStudent(StudentRequest request);

    StudentResponse updateStudent(Integer enrollmentNo, StudentRequest request);

    StudentResponse getStudentById(Integer enrollmentNo);

    void deleteStudent(Integer enrollmentNo);

    StudentWithSubjectResponse getStudentWithSubjectsByEnrollmentNo(Integer enrollmentNo);

    List<StudentWithSubjectResponse> getAllStudentsWithSubjects();
}
