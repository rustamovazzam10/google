package uz.salikhdev.google_lms.domain.dto.request;


import lombok.Builder;
import uz.salikhdev.google_lms.domain.entity.academic.Group;

import java.time.LocalTime;

@Builder
public record UpdateGroupRequest(
        String name,
        Long mentorId,
        LocalTime startTime,
        LocalTime endTime,
        Group.Status status
) {
}
