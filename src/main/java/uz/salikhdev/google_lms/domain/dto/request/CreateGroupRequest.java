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
        String name,

        @NotNull(message = "Course ID is required")
        @Min(1)
        Long courseId,

        @NotNull(message = "Capacity is required")
        @Min(1)
        Long capacity,

        @NotNull(message = "Mentor ID is required")
        @Min(1)
        Long mentorId,

        @NotNull(message = "Start time is required")
        LocalTime startTime,

        @NotNull(message = "End time is required")
        LocalTime endTime,

        @NotNull(message = "Start date is required")
        LocalDate startDate
) {
}
