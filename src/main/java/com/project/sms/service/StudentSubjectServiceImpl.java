package com.project.sms.service;

import org.springframework.stereotype.Service;

import com.project.sms.dto.request.AssignSubjectRequest;
import com.project.sms.model.Student;
import com.project.sms.model.StudentSubject;
import com.project.sms.model.Subject;
import com.project.sms.repository.StudentRepository;
import com.project.sms.repository.SubjectRepository;
import com.project.sms.repository.StudentSubjectRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentSubjectServiceImpl implements StudentSubjectService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final StudentSubjectRepository studentSubjectRepository;

    @Override
    public void assignSubjectToStudent(AssignSubjectRequest request) {
        Integer studentId = request.getStudentId();
        Integer subjectId = request.getSubjectId();

        if (studentSubjectRepository.existsByStudent_EnrollmentNoAndSubject_Id(studentId, subjectId)) {
            throw new IllegalArgumentException("Subject already assigned to student");
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found"));

        StudentSubject studentSubject = new StudentSubject();
        studentSubject.setStudent(student);
        studentSubject.setSubject(subject);

        studentSubjectRepository.save(studentSubject);
    }
}
