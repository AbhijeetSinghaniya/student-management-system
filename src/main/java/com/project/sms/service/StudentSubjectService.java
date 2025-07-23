package com.project.sms.service;

import com.project.sms.dto.request.AssignSubjectRequest;

public interface StudentSubjectService {
    void assignSubjectToStudent(AssignSubjectRequest request);
}
