package com.project.sms.service;

import org.springframework.stereotype.Service;

import com.project.sms.dto.request.SubjectRequest;
import com.project.sms.dto.response.SubjectResponse;

@Service
public interface SubjectService {
    SubjectResponse addSubject(SubjectRequest request);

    void deleteSubject(Integer subjectId);
}
