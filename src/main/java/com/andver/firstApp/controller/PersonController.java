package com.andver.firstApp.controller;

import com.andver.firstApp.domain.Person;
import com.andver.firstApp.domain.PersonBuilder;
import com.andver.firstApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostConstruct
    private void init() {
        PersonBuilder builder = new PersonBuilder();
        personRepository.save(builder.setName("Andrei").setAge(27).build());
        personRepository.save(builder.setName("Siarhei").setAge(20).build());
        personRepository.save(builder.setName("Pavel").setAge(30).build());
        personRepository.save(builder.setName("Sasha").setAge(40).build());
    }

    @GetMapping(path = "/personsController/")
    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping(path = "/personsController/findByName/{name}")
    public Iterable<Person> findByName(@PathVariable String name) {
        return personRepository.findByName(name);
    }

    @GetMapping(path = "/personsController/findByNameContains/{name}")
    public Iterable<Person> findByNameContains(@PathVariable String name) {
        return personRepository.findByNameContains(name);
    }

    @PostMapping(path = "/personsController/create/{name}/{age}")
    public Person createPerson(@PathVariable String name, @PathVariable Integer age) {
        PersonBuilder builder = new PersonBuilder();
        return personRepository.save(builder.setName(name).setAge(age).build());
    }


}
