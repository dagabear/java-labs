package kz.moderntech.controller;

import jakarta.validation.Valid;
import kz.moderntech.model.dto.UserDto;
import kz.moderntech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void createUser(@Valid @RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @GetMapping
    public List<UserDto> findUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
    }

    @PatchMapping("/{id}")
    public void updateUser(@PathVariable int id, @Valid @RequestBody UserDto userDto) {
        userService.updateUser(id, userDto);
    }

}
