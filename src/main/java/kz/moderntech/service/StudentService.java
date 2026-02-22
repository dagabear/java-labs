package kz.moderntech.service;

import kz.moderntech.model.Student;
import kz.moderntech.repository.CourseRepository;
import kz.moderntech.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public void enrollStudentToCourse(long studentId, long courseId) {
        var student = studentRepository.findById(studentId).orElseThrow();
        var course = courseRepository.findById(courseId).orElseThrow();

        student.getCourses().add(course);
        studentRepository.save(student);
    }

    public void delete(long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student getById(long studentId) {
        return studentRepository.findById(studentId).orElseThrow();
    }

}
