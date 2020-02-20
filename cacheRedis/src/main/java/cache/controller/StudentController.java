package cache.controller;

import cache.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class StudentController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations hashOperations;

    private static final String KEY = "Students";

    @PostConstruct
    public void init() {
        hashOperations = redisTemplate.opsForHash();
    }


    @GetMapping("/createStudent/")
    public void createStudent() {
        Student student = new Student(1, "Siarhei", 55);
        hashOperations.put(KEY, student.getId(), student.toString());
    }

    @GetMapping("/getStudent/")
    public String getStudent() {
        return (String) hashOperations.get(KEY, 1);
    }
}
