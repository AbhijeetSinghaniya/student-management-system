package com.project.sms.dto.request;

import jakarta.validation.constraints.NotBlank;

public class SubjectRequest {
    @NotBlank
    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
