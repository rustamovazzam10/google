package uz.salikhdev.google_lms.domain.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record HomeworkCreateRequest(
        @NotNull(message = "Title cannot be null")
        @NotBlank(message = "Title cannot be blank")
        String title,
        String description,
        @NotNull(message = "Content cannot be null")
        @NotBlank(message = "Content cannot be blank")
        String contentUrl,
        @Max(100)
        @Min(1)
        @NotNull(message = "Max score cannot be null")
        Long maxScore
) {
}
