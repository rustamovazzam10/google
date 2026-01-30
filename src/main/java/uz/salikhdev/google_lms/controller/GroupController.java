package uz.salikhdev.google_lms.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SuccessResponse> createGroup(
            @RequestBody CreateGroupRequest request,
            @AuthenticationPrincipal User authUser
    ) {
        groupService.createGroup(request, authUser);
        return ResponseEntity.ok(SuccessResponse.ok("Group created successfully"));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'CEO')")
    public ResponseEntity<?> allGroups() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @PatchMapping("/{groupId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'CEO')")
    public ResponseEntity<SuccessResponse> updateGroup(@PathVariable Long groupId,
                                                       @RequestBody UpdateGroupRequest request,
                                                       @AuthenticationPrincipal User user

    ) {
        groupService.update(groupId, request, user);
        return ResponseEntity.ok(SuccessResponse.ok("Group updated successfully"));
    }

    @DeleteMapping("{groupId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deleteCourse(@PathVariable Long groupId) {
        groupService.delete(groupId);
        return ResponseEntity.ok(SuccessResponse.ok("Group deleted successfully"));
    }


}
