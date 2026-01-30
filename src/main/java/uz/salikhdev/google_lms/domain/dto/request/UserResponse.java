package uz.salikhdev.google_lms.domain.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import uz.salikhdev.google_lms.domain.entity.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record UserResponse(
        @JsonProperty("id")
        Long id,
        @JsonProperty("fullName")
        String fullName,
        @JsonProperty("email")
        String email,
        @JsonProperty("status")
        User.Status status,
        @JsonProperty("role")
        User.Role role,
        @JsonProperty("birthDate")
        LocalDate birthDate,
        @JsonProperty("createdAt")
        LocalDateTime createdAt

) {
}
