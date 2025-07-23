package com.project.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sms.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    boolean existsByName(String name);
}
