package cache.repository;

import cache.domain.Student;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("prod")
@EnableScan
public interface StudentRepository extends CrudRepository<Student, String> {
    Iterable<Student> findByName(String name);

    Iterable<Student> findByNameContains(String name);
}
