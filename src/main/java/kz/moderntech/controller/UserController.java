package kz.moderntech.controller;

import kz.moderntech.model.dto.UserRegDto;
import kz.moderntech.model.dto.UserResponseDto;
import kz.moderntech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRegDto userRegDto) {
        return userService.createUser(userRegDto);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

}
