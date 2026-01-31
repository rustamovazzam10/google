package uz.salikhdev.google_lms.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UpdateUserRequest(
        String firstName,
        String lastName,
        @Email(message = "Email should be valid")
        String email,
        LocalDate birthDate
) {
}
