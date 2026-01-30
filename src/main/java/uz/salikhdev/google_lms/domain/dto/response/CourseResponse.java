package uz.salikhdev.google_lms.domain.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record CourseResponse(
        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("price")
        BigDecimal price,
        @JsonProperty("createAt")
        LocalDateTime createdAt) {
}
