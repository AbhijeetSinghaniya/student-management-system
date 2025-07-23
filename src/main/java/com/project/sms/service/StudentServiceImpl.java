package com.project.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.sms.dto.request.StudentRequest;
import com.project.sms.dto.response.StudentResponse;
import com.project.sms.dto.response.StudentWithSubjectResponse;
import com.project.sms.dto.response.SubjectResponse;
import com.project.sms.model.Student;
import com.project.sms.repository.StudentRepository;
import com.project.sms.repository.StudentSubjectRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentSubjectRepository studentSubjectRepository;

    @Override
    @Transactional
    public StudentResponse createStudent(StudentRequest request) {
        if (studentRepository.existsByEmailId(request.getEmailId())) {
            throw new IllegalArgumentException("Student with this email already exists.");
        }

        Student student = mapToEntity(request);
        Student saved = studentRepository.save(student);
        return mapToResponse(saved);
    }

    @Override
    @Transactional
    public StudentResponse updateStudent(Integer enrollmentNo, StudentRequest request) {
        Student student = studentRepository.findById(enrollmentNo)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + enrollmentNo));

        student.setName(request.getName());
        student.setGender(request.getGender());
        student.setEmailId(request.getEmailId());
        student.setAge(request.getAge());

        Student updated = studentRepository.save(student);
        return mapToResponse(updated);
    }

    @Override
    public StudentResponse getStudentById(Integer enrollmentNo) {
        Student student = studentRepository.findById(enrollmentNo)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + enrollmentNo));
        return mapToResponse(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer enrollmentNo) {
        if (!studentRepository.existsById(enrollmentNo)) {
            throw new EntityNotFoundException("Student not found with id: " + enrollmentNo);
        }
        studentRepository.deleteById(enrollmentNo);
    }

    @Override
    public StudentWithSubjectResponse getStudentWithSubjectsByEnrollmentNo(Integer enrollmentNo) {
        Student student = studentRepository.findById(enrollmentNo)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + enrollmentNo));

        StudentWithSubjectResponse response = new StudentWithSubjectResponse();
        response.setEnrollmentNo(student.getEnrollmentNo());
        response.setName(student.getName());
        response.setEmailId(student.getEmailId());
        response.setGender(student.getGender());
        response.setAge(student.getAge());

        List<SubjectResponse> subjects = studentSubjectRepository.findByStudentEnrollmentNo(enrollmentNo)
                .stream()
                .map(ss -> new SubjectResponse(
                        ss.getSubject().getId(),
                        ss.getSubject().getName()))
                .toList();

        response.setSubjects(subjects);
        return response;
    }

    @Override
    public List<StudentWithSubjectResponse> getAllStudentsWithSubjects() {
        List<Student> students = studentRepository.findAll();

        return students.stream().map(student -> {
            StudentWithSubjectResponse response = new StudentWithSubjectResponse();
            response.setEnrollmentNo(student.getEnrollmentNo());
            response.setName(student.getName());
            response.setEmailId(student.getEmailId());
            response.setAge(student.getAge());
            response.setGender(student.getGender());

            List<SubjectResponse> subjectList = studentSubjectRepository
                    .findByStudentEnrollmentNo(student.getEnrollmentNo())
                    .stream()
                    .map(ss -> new SubjectResponse(ss.getSubject().getId(), ss.getSubject().getName()))
                    .toList();

            response.setSubjects(subjectList);
            return response;
        }).toList();
    }

    private Student mapToEntity(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setGender(request.getGender());
        student.setEmailId(request.getEmailId());
        student.setAge(request.getAge());
        return student;
    }

    private StudentResponse mapToResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setEnrollmentNo(student.getEnrollmentNo());
        response.setName(student.getName());
        response.setGender(student.getGender());
        response.setEmailId(student.getEmailId());
        response.setAge(student.getAge());
        return response;
    }

}
