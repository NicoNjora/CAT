package com.nicollet.cat1.models;

public class ReasonDTO {

    private Long studentId;
    private String reason;

    public ReasonDTO(Long studentId, String reason) {
        this.studentId = studentId;
        this.reason = reason;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
