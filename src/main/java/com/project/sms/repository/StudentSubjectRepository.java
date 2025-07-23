package com.project.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sms.model.StudentSubject;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {
    boolean existsBySubjectId(Integer subjectId);

    boolean existsByStudentIdAndSubjectId(Integer studentId, Integer subjectId);
}
