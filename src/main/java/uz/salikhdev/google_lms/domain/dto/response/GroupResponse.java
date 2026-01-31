package uz.salikhdev.google_lms.domain.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
public record GroupResponse(
        Long id,
        String name,
        Long number,
        Long capacity,
        UserInfo mentor,
        CourseInfo course,
        LocalTime startTime,
        LocalTime endTime,
        LocalDateTime createdAt,
        String status,
        UserInfo createdBy
) {
}
