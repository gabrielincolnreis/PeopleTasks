package com.example.tasks.controller.dto;

import com.example.tasks.model.Person;
import com.example.tasks.model.Task;

import java.util.Date;
import java.util.Objects;

public class TaskWithoutAllocatedDto {
    private Long id;
    private String title;
    private String description;
    private Date deadline;
    private String department;
    private Long duration;
    private Boolean isFinished;

    public TaskWithoutAllocatedDto(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.deadline = task.getDeadline();
        this.department = task.getDepartment();
        this.duration = task.getDuration();
        this.isFinished = task.getFinished();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

}
