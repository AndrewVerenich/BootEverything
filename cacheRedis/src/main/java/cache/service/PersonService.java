package cache.service;

import cache.domain.Person;
import cache.domain.PersonBuilder;
import cache.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profile("local")
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


    @Cacheable(cacheNames = "allPersons")
    public Iterable<Person> getAllPersons() {
        logger.info("Person service method getAllPersons()");
        return personRepository.findAll();
    }

    @CachePut(cacheNames = "allPersons")
    public Iterable<Person> updateCache() {
        logger.info("Person service method updateCache()");
        return personRepository.findAll();
    }

    @Cacheable(cacheNames = "person", key = "#name")
    public Iterable<Person> findByName(String name) {
        logger.info("Person service method findByName(name)");
        return personRepository.findByName(name);
    }

    public Iterable<Person> findByNameContains(String name) {
        return personRepository.findByNameContains(name);
    }

    public void save(Person person) {
        personRepository.save(person);
    }

}
