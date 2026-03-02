package kz.moderntech.controller;

import kz.moderntech.model.dto.StudentCreateDto;
import kz.moderntech.model.dto.StudentResponseDto;
import kz.moderntech.model.dto.StudentUpdateDto;
import kz.moderntech.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentResponseDto createStudent(@RequestBody StudentCreateDto studentCreateDto) {
        return studentService.createStudent(studentCreateDto);
    }

    @PatchMapping
    public StudentResponseDto updateStudent(@RequestBody StudentUpdateDto studentUpdateDto) {
        return studentService.updateStudent(studentUpdateDto);
    }

    @DeleteMapping("/{email}")
    public void deleteStudent(@PathVariable String email) {
        studentService.deleteStudent(email);
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudent(@PathVariable long id) {
        return studentService.getStudent(id);
    }

    @GetMapping
    public List<StudentResponseDto> getStudents() {
        return studentService.getAllStudents();
    }

}
