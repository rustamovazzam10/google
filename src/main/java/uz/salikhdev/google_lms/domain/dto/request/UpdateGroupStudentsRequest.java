package uz.salikhdev.google_lms.domain.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record UpdateGroupStudentsRequest(
        @JsonProperty("groupId")
        Long groupId,
        @JsonProperty("studentId")
        Long studentId,
        @JsonProperty("groupStudentsId")
        Long groupStudentsId
) {
}
