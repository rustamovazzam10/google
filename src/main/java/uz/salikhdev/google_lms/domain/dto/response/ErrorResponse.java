package uz.salikhdev.google_lms.domain.dto.response;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

@Builder
public record ErrorResponse(
        int code,
        String message,
        Map<String, String> errors
) {
    public static ResponseEntity<ErrorResponse> of(HttpStatus status, String message, Map<String, String> errors) {
        return ResponseEntity.status(status)
                .body(ErrorResponse.builder()
                        .code(status.value())
                        .message(message)
                        .build());

    }

    public static ResponseEntity<ErrorResponse> of(HttpStatus status, String message) {
        return of(status, message, null);
    }

    public static void writeToResponse(
            HttpServletResponse response,
            HttpStatus status,
            String message,
            ObjectMapper objectMapper
    ) throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(status.value())
                .message(message)
                .errors(null)
                .build();

        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }


}
