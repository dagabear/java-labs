package kz.moderntech.service;

import kz.moderntech.model.User;
import kz.moderntech.model.dto.UserRegDto;
import kz.moderntech.model.dto.UserResponseDto;
import kz.moderntech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createUser(UserRegDto userRegDto) {
        return userRepository.save(userRegDto.toEntity()).toUserResponseDto();
    }

    public UserResponseDto getUserById(long id) {
        return userRepository.findById(id).orElseThrow().toUserResponseDto();
    }

}
