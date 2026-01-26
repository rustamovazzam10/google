package uz.salikhdev.google_lms.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CreateUserRequest(
        @NotNull(message = "First name is required")
        @NotBlank(message = "First name cannot be blank")
        @JsonProperty("first_name")
        String firstName,
        @NotNull(message = "Last name is required")
        @NotBlank(message = "Last name cannot be blank")
        @JsonProperty("last_name")
        String lastName,
        @Email(message = "Email should be valid")
        @NotNull(message = "Email is required")
        @NotBlank(message = "Email cannot be blank")
        @JsonProperty("email")
        String email,
        @NotNull(message = "Password is required")
        @NotBlank(message = "Password cannot be blank")
        @JsonProperty("password")
        String password,
        @NotNull
        @JsonProperty("birth_date")
        @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
        @Schema(example = "2000-01-01", pattern = "yyyy-MM-dd")
        LocalDate birthDate
) {
}
