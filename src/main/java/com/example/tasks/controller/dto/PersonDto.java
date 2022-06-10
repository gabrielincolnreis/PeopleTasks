package com.example.tasks.controller.dto;

import com.example.tasks.model.Person;
import com.example.tasks.model.Task;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class PersonDto {

    private Long id;
    private String name;
    private String department;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Task> tasks;


    public PersonDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.department = person.getDepartment();
        this.tasks = person.getTasks();
    }
}
