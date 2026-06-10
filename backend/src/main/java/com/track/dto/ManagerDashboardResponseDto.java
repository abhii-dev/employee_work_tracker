package com.track.dto;

public class ManagerDashboardResponseDto {

    private Long managerId;
    private String managerName;

    private long teamSize;

    private long tasksAssigned;

    private long completedTasks;

    private double averageTeamPerformance;

    private String topPerformer;

    public ManagerDashboardResponseDto() {
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public long getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(long teamSize) {
        this.teamSize = teamSize;
    }

    public long getTasksAssigned() {
        return tasksAssigned;
    }

    public void setTasksAssigned(long tasksAssigned) {
        this.tasksAssigned = tasksAssigned;
    }

    public long getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(long completedTasks) {
        this.completedTasks = completedTasks;
    }

    public double getAverageTeamPerformance() {
        return averageTeamPerformance;
    }

    public void setAverageTeamPerformance(double averageTeamPerformance) {
        this.averageTeamPerformance = averageTeamPerformance;
    }

    public String getTopPerformer() {
        return topPerformer;
    }

    public void setTopPerformer(String topPerformer) {
        this.topPerformer = topPerformer;
    }
}