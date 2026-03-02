package kz.moderntech.service;

import kz.moderntech.model.Student;
import kz.moderntech.model.dto.StudentCreateDto;
import kz.moderntech.model.dto.StudentResponseDto;
import kz.moderntech.model.dto.StudentUpdateDto;
import kz.moderntech.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponseDto createStudent(StudentCreateDto studentCreateDto) {
        return studentRepository.save(studentCreateDto.toEntity()).toDto();
    }

    public StudentResponseDto updateStudent(StudentUpdateDto studentUpdateDto) {
        var student = studentRepository.findStudentByEmail(studentUpdateDto.email())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found"));
        student.setAge(Objects.requireNonNullElse(studentUpdateDto.age(), student.getAge()));
        student.setFirstName(Objects.requireNonNullElse(studentUpdateDto.firstName(), student.getFirstName()));
        student.setLastName(Objects.requireNonNullElse(studentUpdateDto.lastName(), student.getLastName()));
        return student.toDto();
    }

    public void deleteStudent(String email) {
        studentRepository.deleteStudentByEmail(email);
    }

    public StudentResponseDto getStudent(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found")).toDto();
    }

    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(Student::toDto)
                .toList();
    }

}
