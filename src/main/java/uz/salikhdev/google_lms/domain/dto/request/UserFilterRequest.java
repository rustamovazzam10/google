package uz.salikhdev.google_lms.domain.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import uz.salikhdev.google_lms.domain.entity.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record UserFilterRequest(
        @JsonProperty("search")
        String search,
        @JsonProperty("status")
        User.Status status,
        @JsonProperty("role")
        User.Role role,
        @JsonProperty("user_id")
        Long userId,
        @JsonProperty("from_date")
        LocalDate fromDate,
        @JsonProperty("to_date")
        LocalDate toDate
) {
}
