package uz.salikhdev.google_lms.domain.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record UpdateGroupStudentsRequest(
        Long groupId,
        Long studentId,
        Long groupStudentsId
) {
}
