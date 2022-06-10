package com.example.tasks.controller;

import com.example.tasks.controller.dto.PersonPeriodDto;
import com.example.tasks.controller.dto.PersonWithoutTaskDto;
import com.example.tasks.controller.dto.TaskWithoutAllocatedDto;
import com.example.tasks.controller.form.PersonForm;
import com.example.tasks.model.Person;
import com.example.tasks.model.Task;
import com.example.tasks.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody PersonForm personForm){

        Person person = personForm.converter();
        personRepository.save(person);

        return ResponseEntity.ok("Pessoa criada com sucesso");
    }

    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody PersonForm personForm){
        Optional<Person> person = personRepository.findById(id);

        if(person.isPresent()){
            Person person1 = personForm.update(id, personRepository);
            return ResponseEntity.ok(new Person(person1));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<Person> person = personRepository.findById(id);

        if(person.isPresent()){
           personRepository.deleteById(id);
           return ResponseEntity.ok("Apagado com sucesso");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<PersonWithoutTaskDto> getPeopleWithDuration(){
        List<Person> personList = personRepository.findAll();
        List<PersonWithoutTaskDto> personWithoutTaskDtos = new ArrayList<>();
        for(Person person : personList){
            PersonWithoutTaskDto personWithoutTaskDto =  new PersonWithoutTaskDto(person);
            personWithoutTaskDtos.add(personWithoutTaskDto);
        }
        return personWithoutTaskDtos;
    }

    @GetMapping("/gastos")
    public List<PersonPeriodDto> getPersonByName(@RequestParam String name){
        List<Person> personList = personRepository.findByName(name);
        List<PersonPeriodDto> personPeriodDtos = new ArrayList<>();
        for(Person person : personList){
            PersonPeriodDto PersonPeriodDto =  new PersonPeriodDto(person);
            personPeriodDtos.add(PersonPeriodDto);
        }
        return personPeriodDtos;
    }



}
