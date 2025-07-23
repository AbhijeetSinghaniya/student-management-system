package com.project.sms.service;

import com.project.sms.dto.request.StudentSubjectRequest;

public interface StudentSubjectService {
    void assignSubjectToStudent(StudentSubjectRequest request);

    void unassignSubject(StudentSubjectRequest request);
}
