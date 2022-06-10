package com.example.tasks.controller.dto;

import com.example.tasks.model.Task;

import java.util.ArrayList;
import java.util.List;

public class ManagerDto {
    private List<String> departments;
    private Long peopleNumber;
    private List<Task> tasks;


    public ManagerDto(Long peopleNumber, List<Task> tasks) {
        List<String> departmentList = new ArrayList<>();
        for(Task task : tasks){
            departmentList.add(task.getDepartment());
        }
        this.departments = departmentList;
        this.peopleNumber = peopleNumber;
        this.tasks = tasks;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    public Long getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Long peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
