package uz.salikhdev.google_lms.service.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.salikhdev.google_lms.domain.dto.response.ResourceCreateResponse;
import uz.salikhdev.google_lms.domain.entity.resource.Resource;
import uz.salikhdev.google_lms.exception.NotFoundException;
import uz.salikhdev.google_lms.repository.ResourceRepository;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final MinioService minioService;
    private final ResourceRepository resourceRepository;

    public ResourceCreateResponse createResource(MultipartFile file, String folder) {
        Resource resource = minioService.upload(file, folder);
        resourceRepository.save(resource);
        return ResourceCreateResponse.builder().url(resource.getUrl()).build();
    }

    public void deleteResource(String key) {
        Resource resource = resourceRepository.findByKey(key)
                .orElseThrow(() -> new NotFoundException("Resource not found"));
        minioService.delete(resource.getKey());
        resource.setStatus(Resource.Status.DELETED);
        resourceRepository.save(resource);
    }
}
