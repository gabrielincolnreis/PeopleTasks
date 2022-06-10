package com.example.tasks.controller.dto;

import com.example.tasks.model.Person;
import com.example.tasks.model.Task;

public class PersonPeriodDto {
    private Long duration;
    private String name;

    public PersonPeriodDto(Person person) {

        Long duration = 0L;
        for(Task task : person.getTasks()){
            duration = duration + task.getDuration();
        }
        duration = duration/person.getTasks().size();

        this.name = person.getName();
        this.duration = duration;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
