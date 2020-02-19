package com.andver.firstApp.repository;

import com.andver.firstApp.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "personsRestResource")
public interface PersonRepository extends JpaRepository<Person, Long> {

    Iterable<Person> findByName(String name);

    Iterable<Person> findByNameContains(String name);

}
