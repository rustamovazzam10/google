package uz.salikhdev.google_lms.domain.dto.response;

import java.math.BigDecimal;

public record CourseInfo(
        Long id,
        String name,
        BigDecimal price
) {
}
