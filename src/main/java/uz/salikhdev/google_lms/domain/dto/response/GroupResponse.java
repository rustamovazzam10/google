package uz.salikhdev.google_lms.domain.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import uz.salikhdev.google_lms.domain.entity.academic.Course;
import uz.salikhdev.google_lms.domain.entity.user.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
public record GroupResponse(
        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("number")
        Long number,
        @JsonProperty("capacity")
        Long capacity,
        @JsonProperty("mentor")
        User mentor,
        @JsonProperty("course")
        Course course,
        @JsonProperty("startTime")
        LocalTime startTime,
        @JsonProperty("endTime")
        LocalTime endTime,
        @JsonProperty("createdAt")
        LocalDateTime createdAt,
        @JsonProperty("status")
        String status,
        @JsonProperty("createBy")
        User createdBy



) {
}
