package uz.salikhdev.google_lms.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record LoginRequest(
        @Email
        @NotBlank(message = "Email cannot be blank")
        @NotNull(message = "Email cannot be null")
        String email,
        @NotBlank(message = "Password cannot be blank")
        @NotNull(message = "Password cannot be null")
        String password,
        LocalDateTime loginAt,
        LocalDate date,
        LocalTime time
) {
}
