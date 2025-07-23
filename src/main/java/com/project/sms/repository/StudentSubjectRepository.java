package com.project.sms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sms.model.StudentSubject;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {
    boolean existsBySubjectId(Integer subjectId);

    boolean existsByStudent_EnrollmentNoAndSubject_Id(Integer studentId, Integer subjectId);

    List<StudentSubject> findByStudentEnrollmentNo(Integer enrollmentNo);

    Optional<StudentSubject> findByStudentEnrollmentNoAndSubjectId(Integer studentId, Integer subjectId);
}
