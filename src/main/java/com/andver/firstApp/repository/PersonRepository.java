package com.andver.firstApp.repository;

import com.andver.firstApp.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Iterable<Person> findByName(String name);

    Iterable<Person> findByNameContains(String name);

}
