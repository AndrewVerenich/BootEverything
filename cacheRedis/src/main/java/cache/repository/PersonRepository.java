package cache.repository;

import cache.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    Iterable<Person> findByName(String name);

    Iterable<Person> findByNameContains(String name);
}
