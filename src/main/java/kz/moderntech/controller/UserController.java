package kz.moderntech.controller;

import kz.moderntech.model.dto.UserRegDto;
import kz.moderntech.model.dto.UserResponseDto;
import kz.moderntech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRegDto userRegDto) {
        return
    }

}
