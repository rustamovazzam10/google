package uz.salikhdev.google_lms.domain.dto.response;

import lombok.Builder;

@Builder
public record ResourceCreateResponse(
        String url
) {
}
