package kz.moderntech.controller;

import kz.moderntech.controller.base.BaseController;
import kz.moderntech.model.Student;
import kz.moderntech.repository.StudentRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
@Validated
public class StudentController extends BaseController<Student, Long> {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository repository) {
        super(repository);
        this.studentRepository = repository;
    }

    @GetMapping("/find-by-course/{course}")
    public List<Student> findByCourse(@PathVariable Long course) {
        return studentRepository.findStudentsByCourse(course);
    }

}
