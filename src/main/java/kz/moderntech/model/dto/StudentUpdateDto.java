package kz.moderntech.model.dto;

public record StudentUpdateDto(
        String firstName,
        String lastName,
        String email,
        Short age
) {
}
