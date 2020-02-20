package cache.controller;

import cache.domain.Person;
import cache.domain.PersonBuilder;
import cache.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private PersonRepository personRepository;
    private Person simplePerson = new PersonBuilder().setName("Andrei").setAge(27).build();

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/createPerson/")
    public void createPerson() {
        personRepository.save(simplePerson);
    }

    @GetMapping("/getPersons/")
    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/deletePerson/")
    public void deletePerson() {
        personRepository.delete(simplePerson);
    }

    @GetMapping("/deleteAllPersons/")
    public void deleteAllPersons() {
        personRepository.deleteAll();
    }
}
