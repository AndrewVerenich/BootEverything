package cache.service;

import cache.domain.Student;
import cache.repository.StudentRepository;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profile("prod")
@Component
public class StudentService {

    private Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    private void init() {
        studentRepository.save(new Student("Andrei", 27));
        studentRepository.save(new Student("Siarhei", 20));
        studentRepository.save(new Student("Pavel", 40));
    }


    public Iterable<Student> getAllStudents() {
        logger.info("Student service method getAllStudents()");
        return studentRepository.findAll();
    }

    public Iterable<Student> findByName(String name) {
        logger.info("Student service method findByName(name)");
        return studentRepository.findByName(name);
    }

    public Iterable<Student> findByNameContains(String name) {
        return studentRepository.findByNameContains(name);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

}
