package com.project.sms.dto.request;

import jakarta.validation.constraints.NotNull;

public class AssignSubjectRequest {
    @NotNull
    private Integer studentId;

    @NotNull
    private Integer subjectId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}
