package uz.salikhdev.google_lms.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.salikhdev.google_lms.domain.dto.request.CreateGroupRequest;
import uz.salikhdev.google_lms.domain.dto.request.UpdateGroupRequest;
import uz.salikhdev.google_lms.domain.dto.response.SuccessResponse;
import uz.salikhdev.google_lms.domain.entity.user.User;
import uz.salikhdev.google_lms.service.group.GroupService;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
@Tag(name = "Group API")
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_USER','ADMIN')")
    public ResponseEntity<SuccessResponse> createGroup(
            @RequestBody CreateGroupRequest request,
            @AuthenticationPrincipal User authUser
    ) {
        groupService.createGroup(request, authUser);
        return ResponseEntity.ok(SuccessResponse.ok("Group created successfully"));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('SUPER_USER','ADMIN', 'CEO')")
    public ResponseEntity<?> allGroups() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @PatchMapping("/{groupId}")
    @PreAuthorize("hasAnyRole('SUPER_USER','ADMIN', 'CEO')")
    public ResponseEntity<SuccessResponse> updateGroup(@PathVariable Long groupId,
                                                       @RequestBody UpdateGroupRequest request
    ) {
        groupService.update(groupId, request);
        return ResponseEntity.ok(SuccessResponse.ok("Group updated successfully"));
    }

    @DeleteMapping("{groupId}")
    @PreAuthorize("hasAnyRole('SUPER_USER','ADMIN')")
    public ResponseEntity<?> deleteCourse(@PathVariable Long groupId) {
        groupService.delete(groupId);
        return ResponseEntity.ok(SuccessResponse.ok("Group deleted successfully"));
    }
}
