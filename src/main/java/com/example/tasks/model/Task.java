package com.example.tasks.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date deadline;
    private String department;
    private Long duration;

    @OneToOne(fetch = FetchType.EAGER)
    private Person allocatedPerson;
    private Boolean isFinished = false;

    public Task(String title, String description, Date deadline, String department, Long duration) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.department = department;
        this.duration = duration;
    }

    public Task(Task task1) {
        this.title = task1.title;
        this.description = task1.description;
        this.deadline = task1.deadline;
        this.department = task1.department;
        this.duration = task1.duration;
    }


    public Task() {
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

    public Person getAllocatedPerson() {
        return allocatedPerson;
    }

    public void setAllocatedPerson(Person allocatedPerson) {
        this.allocatedPerson = allocatedPerson;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }
}
