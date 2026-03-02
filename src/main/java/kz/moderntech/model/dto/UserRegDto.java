package kz.moderntech.model.dto;

public record UserRegDto(
        String username,
        String password,
        String email,
        short age // primitives are non null by default
) {
}
