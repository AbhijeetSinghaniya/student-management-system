package com.project.sms.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import com.project.sms.dto.request.StudentSubjectRequest;
import com.project.sms.repository.StudentRepository;
import com.project.sms.repository.StudentSubjectRepository;
import com.project.sms.repository.SubjectRepository;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
class StudentSubjectServiceImplTest {

    @Mock
    StudentSubjectRepository ssRepo;
    @Mock
    StudentRepository studentRepo;
    @Mock
    SubjectRepository subjectRepo;
    @InjectMocks
    StudentSubjectServiceImpl service;

    @Test
    void unassignSubject_throws_whenMappingMissing() {
        var req = new StudentSubjectRequest();
        req.setStudentId(1);
        req.setSubjectId(2);

        when(ssRepo.findByStudentEnrollmentNoAndSubjectId(1, 2))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.unassignSubject(req))
                .isInstanceOf(EntityNotFoundException.class);
    }
}
