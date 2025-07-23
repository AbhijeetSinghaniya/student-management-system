package com.project.sms.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class StudentWithSubjectResponse {
    private Integer enrollmentNo;
    private String name;
    private String emailId;
    private String gender;
    private int age;

    private List<SubjectResponse> subjects;
}
