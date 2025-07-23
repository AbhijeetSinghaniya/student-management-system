package com.project.sms.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.sms.repository.StudentSubjectRepository;
import com.project.sms.repository.SubjectRepository;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceImplTest {
    @Mock
    SubjectRepository subjectRepo;
    @Mock
    StudentSubjectRepository studentSubjectRepo;
    @InjectMocks
    SubjectServiceImpl subjectService;

    @Test
    void deleteSubject_blocks_whenAssigned() {
        Integer subjId = 10;
        when(subjectRepo.existsById(subjId)).thenReturn(true);
        when(studentSubjectRepo.existsBySubjectId(subjId)).thenReturn(true);

        assertThatThrownBy(() -> subjectService.deleteSubject(subjId))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("assigned");

        verify(subjectRepo, never()).deleteById(any());
    }
}
