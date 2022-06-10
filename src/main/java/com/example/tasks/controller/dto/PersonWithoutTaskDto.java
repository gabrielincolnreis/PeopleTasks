package com.example.tasks.controller.dto;

import com.example.tasks.model.Person;
import com.example.tasks.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PersonWithoutTaskDto {
    private Long id;
    private String name;
    private String department;
    private Long duration;

    public PersonWithoutTaskDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.department = person.getDepartment();

        if(Objects.nonNull(person.getTasks())){
            this.duration = 0L;
            for (Task task : person.getTasks()){
                this.duration += task.getDuration();
            }
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
