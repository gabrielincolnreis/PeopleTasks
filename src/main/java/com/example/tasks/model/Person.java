package com.example.tasks.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Task> tasks;

    public Person() {
    }

    public Person(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public Person(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.department = person.getDepartment();
        this.tasks = person.getTasks();
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
