package com.track.dto;

public class PerformanceResponseDto {

    private Long employeeId;
    private String employeeName;

    private double taskScore;
    private double attendanceScore;
    private double reviewScore;
    private double finalScore;

    public PerformanceResponseDto() {
    }

    public PerformanceResponseDto(Long employeeId,
                                  String employeeName,
                                  double taskScore,
                                  double attendanceScore,
                                  double reviewScore,
                                  double finalScore) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.taskScore = taskScore;
        this.attendanceScore = attendanceScore;
        this.reviewScore = reviewScore;
        this.finalScore = finalScore;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getTaskScore() {
        return taskScore;
    }

    public void setTaskScore(double taskScore) {
        this.taskScore = taskScore;
    }

    public double getAttendanceScore() {
        return attendanceScore;
    }

    public void setAttendanceScore(double attendanceScore) {
        this.attendanceScore = attendanceScore;
    }

    public double getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(double reviewScore) {
        this.reviewScore = reviewScore;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }
}