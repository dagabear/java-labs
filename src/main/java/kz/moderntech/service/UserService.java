package kz.moderntech.service;

import kz.moderntech.model.dto.UserResponseDto;
import kz.moderntech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createUser() {

    }

}
