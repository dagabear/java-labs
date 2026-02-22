package kz.moderntech.controller;

import kz.moderntech.model.Student;
import kz.moderntech.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public void enrollStudentToCourse(@PathVariable long studentId, @PathVariable long courseId) {
        studentService.enrollStudentToCourse(studentId, courseId);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable long studentId) {
        studentService.delete(studentId);
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable long studentId) {
        return studentService.getById(studentId);
    }

}
