package kz.moderntech.model.dto;

public record UserResponseDto(
        String username,
        String password,
        String email,
        short age
) {

}
