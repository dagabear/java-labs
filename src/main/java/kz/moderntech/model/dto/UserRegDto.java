package kz.moderntech.model.dto;

import kz.moderntech.model.User;

public record UserRegDto(
        String username,
        String password,
        String email,
        short age // primitives are non null by default
) {
    public User toEntity() {
        return new User(username, password, email, age);
    }
}
