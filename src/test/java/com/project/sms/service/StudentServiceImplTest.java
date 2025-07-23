package com.project.sms.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import com.project.sms.dto.request.StudentRequest;
import com.project.sms.dto.response.StudentResponse;
import com.project.sms.model.Student;
import com.project.sms.repository.StudentRepository;

@org.junit.jupiter.api.extension.ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {
    @Mock
    StudentRepository studentRepo;
    @InjectMocks
    StudentServiceImpl studentService;

    StudentRequest req;

    @BeforeEach
    void setUp() {
        req = new StudentRequest();
        req.setName("Aarav");
        req.setGender("male");
        req.setEmailId("aarav@abc.com");
        req.setAge(12);
    }

    @Test
    void createStudent_succeeds_whenEmailUnique() {
        when(studentRepo.existsByEmailId(req.getEmailId())).thenReturn(false);
        when(studentRepo.save(any(Student.class))).thenAnswer(i -> {
            Student s = i.getArgument(0);
            s.setEnrollmentNo(1);
            return s;
        });

        // when
        StudentResponse resp = studentService.createStudent(req);

        // then
        assertThat(resp.getEnrollmentNo()).isEqualTo(1);
        ArgumentCaptor<Student> captor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepo).save(captor.capture());
        assertThat(captor.getValue().getEmailId()).isEqualTo("aarav@abc.com");
    }

    @Test
    void createStudent_throws_whenEmailExists() {
        when(studentRepo.existsByEmailId(req.getEmailId())).thenReturn(true);

        assertThatThrownBy(() -> studentService.createStudent(req))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("email");
        verify(studentRepo, never()).save(any());
    }
}
