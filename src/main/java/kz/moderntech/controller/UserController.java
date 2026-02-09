package kz.moderntech.controller;

import kz.moderntech.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/createUser")
    public void createUser(@RequestBody User user) {
        users.add(user);
    }

    @GetMapping("/readUsers")
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/readUser/{name}")
    public User getUser(@PathVariable String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    // локальный репозиторий
    private final List<User> users = new ArrayList<>();

}
