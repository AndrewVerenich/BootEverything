package cache.controller;

import cache.domain.Person;
import cache.domain.PersonBuilder;
import cache.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private PersonService personService;
    private Person simplePerson = new PersonBuilder().setName("Andrei").setAge(27).build();

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/createPerson/")
    public void createPerson() {
        personService.save(simplePerson);
    }

    @GetMapping("/getPersons/")
    public Iterable<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/updatePersonsCache/")
    public void updatePersonsCache() {
        personService.updateCache();
    }

    @GetMapping("/getPerson/{name}")
    public Iterable<Person> getPersonByName(@PathVariable String name) {
        return personService.findByName(name);
    }

//    @GetMapping("/deletePerson/")
//    public void deletePerson() {
//        personService.delete(simplePerson);
//    }
//
//    @GetMapping("/deleteAllPersons/")
//    public void deleteAllPersons() {
//        personService.deleteAll();
//    }
}
