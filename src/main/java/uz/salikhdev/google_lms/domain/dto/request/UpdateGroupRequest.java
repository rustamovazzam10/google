package uz.salikhdev.google_lms.domain.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import uz.salikhdev.google_lms.domain.entity.academic.Course;
import uz.salikhdev.google_lms.domain.entity.academic.Group;
import uz.salikhdev.google_lms.domain.entity.user.User;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
public record UpdateGroupRequest(
        @JsonProperty("name")
        String name,
        @JsonProperty("number")
        Long number,
        @JsonProperty("capacity")
        Long capacity,
        @JsonProperty("mentor_id")
        Long mentorId,
        @JsonProperty("course_id")
        Long courseId,
        @JsonProperty("start_time")
        LocalTime startTime,
        @JsonProperty("end_time")
        LocalTime endTime,
        @JsonProperty("status")
        Group.Status status
) {
}
