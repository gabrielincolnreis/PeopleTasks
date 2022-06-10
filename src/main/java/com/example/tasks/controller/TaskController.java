package com.example.tasks.controller;

import com.example.tasks.controller.dto.TaskWithoutAllocatedDto;
import com.example.tasks.controller.form.TaskForm;
import com.example.tasks.model.Person;
import com.example.tasks.model.Task;
import com.example.tasks.repository.PersonRepository;
import com.example.tasks.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<TaskWithoutAllocatedDto> getAllTasks(){
        List<Task> tasks = tasksRepository.findAll();
        List<TaskWithoutAllocatedDto> taskWithoutAllocatedDtos = new ArrayList<>();
        for(Task task : tasks){
            TaskWithoutAllocatedDto taskWithoutAllocatedDto =  new TaskWithoutAllocatedDto(task);
            taskWithoutAllocatedDtos.add(taskWithoutAllocatedDto);
        }

        return taskWithoutAllocatedDtos;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody TaskForm taskForm){

        Task task = taskForm.converter();
        tasksRepository.save(task);

        return ResponseEntity.ok("Tarefa criada com sucesso");
    }

    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody TaskForm taskForm){
        Optional<Task> task = tasksRepository.findById(id);

        if(task.isPresent()){
            Task task1 = taskForm.update(id, tasksRepository);
            return ResponseEntity.ok(new Task(task1));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<Task> task = tasksRepository.findById(id);

        if(task.isPresent()){
            tasksRepository.deleteById(id);
            return ResponseEntity.ok("Apagado com sucesso");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/alocar/{tasksId}")
    @Transactional
    public ResponseEntity<String> allocate(@PathVariable Long tasksId, @RequestParam Long personId){
        Optional<Task> task = tasksRepository.findById(tasksId);
        Optional<Person> person = personRepository.findById(personId);

        if(task.isPresent() && person.isPresent()){
            if(task.get().getDepartment().equals(person.get().getDepartment())){
                task.get().setAllocatedPerson(person.get());

                person.get().getTasks().add(task.get());
                person.get().setTasks(person.get().getTasks());
                return ResponseEntity.ok("Alocado com sucesso");
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/finalizar/{tasksId}")
    @Transactional
    public ResponseEntity<String> finish(@PathVariable Long tasksId){
        Optional<Task> task = tasksRepository.findById(tasksId);

        if(task.isPresent()){
                if(task.get().getFinished()){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tarefa finalizada anteriormente");
                }
                task.get().setFinished(true);
                return ResponseEntity.ok("Tarefa finalizada");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/pendentes")
    public List<Task> get3TasksWithoutPeople(){
        List<Task> tasks = tasksRepository.findAllByOrderByDeadlineAsc();
        List<Task> old3tasks = new ArrayList<>();
        for(Task task : tasks){
            if(Objects.isNull(task.getAllocatedPerson())){
                old3tasks.add(task);
            }
        }
        if(old3tasks.size()>3){
            return old3tasks.subList(0,3);
        }
        return old3tasks;
    }

}

