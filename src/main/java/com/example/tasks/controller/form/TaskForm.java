package com.example.tasks.controller.form;

import com.example.tasks.model.Task;
import com.example.tasks.repository.TasksRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TaskForm {
    private String title;
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date deadline;
    private String department;
    private Long duration;

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

    public Task converter(){
        return new Task(title, description, deadline, department, duration);
    }


    public Task update(Long id, TasksRepository tasksRepository){
        Task task = tasksRepository.getById(id);

        task.setTitle(this.title);
        task.setDescription(this.description);
        task.setDeadline(this.deadline);
        task.setDepartment(this.department);
        task.setDuration(this.duration);

        return task;
    }
}
