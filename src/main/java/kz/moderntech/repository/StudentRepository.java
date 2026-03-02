package kz.moderntech.repository;

import kz.moderntech.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
    void deleteStudentByEmail(String email);
}
