package uz.salikhdev.google_lms.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uz.salikhdev.google_lms.domain.dto.response.ResourceCreateResponse;
import uz.salikhdev.google_lms.domain.dto.response.SuccessResponse;
import uz.salikhdev.google_lms.service.resource.ResourceService;

@RestController
@RequestMapping("/api/resources")
@RequiredArgsConstructor
@Tag(name = "Resource API")
public class ResourceController {

    private final ResourceService resourceService;


    @PostMapping(path = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<?> uploadResource(
            @RequestPart("file") MultipartFile file,
            @RequestPart("folder") String folder
    ) {
        ResourceCreateResponse response = resourceService.createResource(file, folder);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteResource(
            @RequestPart("url") String key
    ) {
        resourceService.deleteResource(key);
        return ResponseEntity.ok(SuccessResponse.ok("Resource deleted successfully"));
    }

}
