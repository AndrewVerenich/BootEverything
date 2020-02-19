package com.andver.firstApp.controller;

import com.andver.firstApp.domain.Person;
import com.andver.firstApp.domain.PersonBuilder;
import com.andver.firstApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    CacheManager cacheManager;



    @GetMapping(path = "/personsController/")
    public Iterable<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(path = "/personsController/findByName/{name}")
    public Iterable<Person> findByName(@PathVariable String name) {
        return personService.findByName(name);
    }

    @GetMapping(path = "/personsController/findByNameContains/{name}")
    public Iterable<Person> findByNameContains(@PathVariable String name) {
        return personService.findByNameContains(name);
    }

    @PostMapping(path = "/personsController/create/{name}/{age}")
    public Person createPerson(@PathVariable String name, @PathVariable Integer age) {
        PersonBuilder builder = new PersonBuilder();
        return personService.save(builder.setName(name).setAge(age).build());
    }


}
