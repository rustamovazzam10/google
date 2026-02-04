package uz.salikhdev.google_lms.domain.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import uz.salikhdev.google_lms.domain.entity.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record UserFilterRequest(
        String search,
        User.Status status,
        User.Role role,
        Long userId,
        LocalDate fromDate,
        LocalDate toDate
) {
}
