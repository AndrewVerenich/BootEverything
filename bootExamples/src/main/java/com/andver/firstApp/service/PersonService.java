package com.andver.firstApp.service;

import com.andver.firstApp.domain.Person;
import com.andver.firstApp.domain.PersonBuilder;
import com.andver.firstApp.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonService.class);

    private PersonRepository personRepository;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    private void init() {
        PersonBuilder builder = new PersonBuilder();
        personRepository.save(builder.setName("Andrei").setAge(27).build());
        personRepository.save(builder.setName("Siarhei").setAge(20).build());
        personRepository.save(builder.setName("Pavel").setAge(30).build());
        personRepository.save(builder.setName("Sasha").setAge(40).build());
    }


    @Cacheable(value = "users")
    public Iterable<Person> getAllPersons() {
        logger.info("Person service method getAllPersons()");
        return personRepository.findAll();
    }

    public Iterable<Person> findByName(String name) {
        logger.info("Person service method findByName(name)");
        return personRepository.findByName(name);
    }

    @Cacheable(cacheNames = "usersByName", key = "#name")
    public Iterable<Person> findByNameContains(String name) {
        return personRepository.findByNameContains(name);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

}
