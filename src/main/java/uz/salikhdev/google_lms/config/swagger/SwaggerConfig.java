package uz.salikhdev.google_lms.config.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "LMS Google",
                version = "1.0.0",
                contact = @Contact(name = "Muhammadsolih")
        ),
        security = @SecurityRequirement(name = "Bearer Token")
)
@SecuritySchemes({
        @SecurityScheme(
                name = "Bearer Token",
                type = SecuritySchemeType.HTTP,
                scheme = "bearer",
                bearerFormat = "JWT"
        )
})
public class SwaggerConfig {


    static {
        // LocalDate: yyyy-MM-dd (example: 2020-01-01)
        SpringDocUtils.getConfig().replaceWithSchema(
                LocalDate.class,
                new Schema<LocalDate>()
                        .type("string")
                        .format("date")
                        .example(LocalDate.now())
        );

        // LocalTime: HH:mm (example: 00:00)
        SpringDocUtils.getConfig().replaceWithSchema(
                LocalTime.class,
                new Schema<LocalTime>()
                        .type("string")
                        .format("time")
                        .example(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))
        );

        // LocalDateTime: yyyy-MM-dd HH:mm (example: 2020-01-01 00:00)
        SpringDocUtils.getConfig().replaceWithSchema(
                LocalDateTime.class,
                new Schema<LocalDateTime>()
                        .type("string")
                        .format("date-time")
                        .example(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
        );
    }


    @Bean
    public OpenApiCustomizer serverUrlCustomizer() {
        return openApi -> {
            Server server = new Server();
            server.setUrl("/");
            server.setDescription("Auto detected server");
            openApi.setServers(List.of(server));
        };
    }

    @Bean
    public ModelResolver modelResolver() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        return new ModelResolver(objectMapper);
    }

}