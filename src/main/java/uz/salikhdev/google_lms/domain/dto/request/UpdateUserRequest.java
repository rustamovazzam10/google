package uz.salikhdev.google_lms.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UpdateUserRequest(
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        @Email(message = "Email should be valid")
        @JsonProperty("email")
        String email,
        @JsonProperty("birth_date")
        @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
        @Schema(example = "2000-01-01", pattern = "yyyy-MM-dd")
        LocalDate birthDate
) {
}
