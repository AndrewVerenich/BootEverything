package cache.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    private HashOperations hashOperations;
//
//    private static final String KEY = "Students";
//
//    @PostConstruct
//    public void init() {
//        hashOperations = redisTemplate.opsForHash();
//    }
//
//
//    @GetMapping("/createStudent/")
//    public void createStudent() {
//        Student student = new Student(1, "Siarhei", 55);
//        hashOperations.put(KEY, student.getId(), student.toString());
//    }
//
//    @GetMapping("/getStudent/")
//    public String getStudent() {
//        return (String) hashOperations.get(KEY, 1);
//    }
}
