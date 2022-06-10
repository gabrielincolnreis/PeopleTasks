package com.example.tasks.controller;

import com.example.tasks.controller.dto.ManagerDto;
import com.example.tasks.model.Task;
import com.example.tasks.repository.PersonRepository;
import com.example.tasks.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public ManagerDto getManager(){
        Long count = personRepository.count();
        List<Task> taskList = tasksRepository.findAll();

        return new ManagerDto(count, taskList);
    }
}
