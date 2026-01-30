package uz.salikhdev.google_lms.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.salikhdev.google_lms.domain.dto.request.GroupStudentsRequest;
import uz.salikhdev.google_lms.domain.dto.request.UpdateGroupStudentsRequest;
import uz.salikhdev.google_lms.domain.dto.response.SuccessResponse;
import uz.salikhdev.google_lms.domain.entity.academic.GroupStudents;
import uz.salikhdev.google_lms.service.GroupStudentsService;

@RestController
@RequestMapping("/api/group-students")
@RequiredArgsConstructor
@Tag(name = "Group students API")
public class GroupStudentsController {
    private final GroupStudentsService groupStudentsService;


    @PostMapping("/join")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SuccessResponse> createGroupStudents(@RequestBody GroupStudentsRequest request) {
        groupStudentsService.join(request);
        return ResponseEntity.ok(SuccessResponse.ok("The group students have been successfully joined!"));
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SuccessResponse> updateGroupStudents(@RequestBody UpdateGroupStudentsRequest request) {
        groupStudentsService.update(request);
        return ResponseEntity.ok(SuccessResponse.ok("The group students have been updated!"));
    }

    @GetMapping("/students/{groupId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getGroupStudents(@PathVariable Long groupId) {
     return ResponseEntity.ok(groupStudentsService.getStudents(groupId));

    }
    @GetMapping("/groups/{studentId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getGroups(@PathVariable Long studentId) {
        return ResponseEntity.ok(groupStudentsService.getGroups(studentId));

    }


}
