package uz.salikhdev.google_lms.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateGroupRequest(
        @NotNull(message = "Name is required")
        @NotBlank(message = "Name cannot be blank")
        @JsonProperty("name")
        String name,

        @NotNull(message = "Course ID is required")
        @Min(1)
        @JsonProperty("course_id")
        Long courseId,

        @NotNull(message = "Capacity is required")
        @Min(1)
        @JsonProperty("capacity")
        Long capacity,

        @NotNull(message = "Mentor ID is required")
        @Min(1)
        @JsonProperty("mentor_id")
        Long mentorId,

        @NotNull(message = "Start time is required")
        @JsonProperty("start_time")
        @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
        LocalTime startTime,

        @NotNull(message = "End time is required")
        @JsonProperty("end_time")
        @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
        LocalTime endTime,

        @NotNull(message = "Start date is required")
        @JsonProperty("start_date")
        @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
        LocalDate startDate
) {
}
