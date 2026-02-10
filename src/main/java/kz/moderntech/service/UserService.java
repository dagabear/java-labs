package kz.moderntech.service;

import kz.moderntech.model.User;
import kz.moderntech.model.dto.UserDto;
import kz.moderntech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void addUser(UserDto userDto) {
        userRepository.save(userDto.toEntity());
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(User::toDto).collect(Collectors.toList());
    }

    public UserDto getUserById(long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        return user.toDto();
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(long id, UserDto userDto) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        user.setName(userDto.name());
        user.setEmail(userDto.email());
        userRepository.save(user);
    }

}
