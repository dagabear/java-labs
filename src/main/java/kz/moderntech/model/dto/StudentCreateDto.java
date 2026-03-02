package kz.moderntech.model.dto;

import kz.moderntech.model.Student;

public record StudentCreateDto(
        String firstName,
        String lastName,
        String email,
        short age
) {
    public Student toEntity() {
        return new Student(firstName, lastName, email, age);
    }
}
