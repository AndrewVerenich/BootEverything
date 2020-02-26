package cache.controller;

import cache.domain.Student;
import cache.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("prod")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/createStudent/")
    public void createStudent() {
        Student student = new Student("Siarhei", 55);
        studentService.save(student);
    }

    @GetMapping("/getStudents/")
    public Iterable<Student> getStudents() {
        return studentService.getAllStudents();
    }
}
