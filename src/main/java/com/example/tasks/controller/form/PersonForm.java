package com.example.tasks.controller.form;

import com.example.tasks.model.Person;
import com.example.tasks.repository.PersonRepository;

public class PersonForm {
    private String name;
    private String department;

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

    public Person converter(){
        return new Person(name, department);
    }

    public Person update(Long id, PersonRepository personRepository){
        Person person = personRepository.getById(id);

        person.setName(this.name);
        person.setDepartment(this.department);

        return person;
    }
}
