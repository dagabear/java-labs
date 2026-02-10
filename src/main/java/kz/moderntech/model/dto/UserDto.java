package kz.moderntech.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kz.moderntech.model.User;

public record UserDto(
        long id,
        @NotNull @Size(min = 3)
        String name,
        @NotNull String email
) {
    public User toEntity() {
        return new User(name, email);
    }
}
