package com.project.sms.service;

import org.springframework.stereotype.Service;

import com.project.sms.dto.request.SubjectRequest;
import com.project.sms.dto.response.SubjectResponse;
import com.project.sms.model.Subject;
import com.project.sms.repository.SubjectRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    // private final StudentSubjectRepository studentSubjectRepository;

    @Override
    public SubjectResponse addSubject(SubjectRequest request) {
        if (subjectRepository.existsByName(request.getSubjectName())) {
            throw new IllegalArgumentException("Subject already exists");
        }
        Subject subject = new Subject();
        subject.setName(request.getSubjectName());

        Subject saved = subjectRepository.save(subject);
        SubjectResponse response = new SubjectResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        return response;
    }

    @Override
    public void deleteSubject(Integer subjectId) {
        if (!subjectRepository.existsById(subjectId)) {
            throw new EntityNotFoundException("Subject not found");
        }

        // if (studentSubjectRepository.existsBySubjectId(subjectId)) {
        // throw new IllegalStateException("Cannot delete subject assigned to a
        // student");
        // }

        subjectRepository.deleteById(subjectId);
    }
}
