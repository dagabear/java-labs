package kz.moderntech.model.dto;

import java.time.LocalDateTime;

public record StudentResponseDto(
        String firstName,
        String lastName,
        String email,
        short age,
        LocalDateTime createdDate
) {
}
