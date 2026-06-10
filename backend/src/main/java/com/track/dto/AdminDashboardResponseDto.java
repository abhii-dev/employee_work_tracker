package com.track.dto;

public class AdminDashboardResponseDto {

    private long totalEmployees;
    private long totalManagers;
    private long totalTasks;
    private long completedTasks;
    private long pendingTasks;
    private double averagePerformanceScore;
    private String topPerformer;

    public AdminDashboardResponseDto() {
    }

    public long getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public long getTotalManagers() {
        return totalManagers;
    }

    public void setTotalManagers(long totalManagers) {
        this.totalManagers = totalManagers;
    }

    public long getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(long totalTasks) {
        this.totalTasks = totalTasks;
    }

    public long getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(long completedTasks) {
        this.completedTasks = completedTasks;
    }

    public long getPendingTasks() {
        return pendingTasks;
    }

    public void setPendingTasks(long pendingTasks) {
        this.pendingTasks = pendingTasks;
    }

    public double getAveragePerformanceScore() {
        return averagePerformanceScore;
    }

    public void setAveragePerformanceScore(double averagePerformanceScore) {
        this.averagePerformanceScore = averagePerformanceScore;
    }

    public String getTopPerformer() {
        return topPerformer;
    }

    public void setTopPerformer(String topPerformer) {
        this.topPerformer = topPerformer;
    }
}