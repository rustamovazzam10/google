package uz.salikhdev.google_lms.service.group;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.salikhdev.google_lms.domain.dto.request.CreateGroupRequest;
import uz.salikhdev.google_lms.domain.entity.academic.Course;
import uz.salikhdev.google_lms.domain.entity.academic.Group;
import uz.salikhdev.google_lms.domain.entity.user.User;
import uz.salikhdev.google_lms.exception.NotFoundException;
import uz.salikhdev.google_lms.repository.CourseRepository;
import uz.salikhdev.google_lms.repository.GroupRepository;
import uz.salikhdev.google_lms.repository.UserRepository;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class GroupService {


    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final Random random;


    public void createGroup(CreateGroupRequest request, User authUser) {

        long groupNumber = random.nextLong(1000, 9999);

        if (groupRepository.existsByNumber(groupNumber)) {
            createGroup(request, authUser);
        }

        Course course = courseRepository.findById(request.courseId())
                .orElseThrow(() -> new NotFoundException("Course not found"));

        User mentor = userRepository.findById(request.mentorId())
                .orElseThrow(() -> new NotFoundException("Mentor not found"));

        Group group = Group.builder()
                .name(request.name())
                .number(groupNumber)
                .capacity(request.capacity())
                .course(course)
                .mentor(mentor)
                .startDate(request.startDate())
                .startTime(request.startTime())
                .status(Group.Status.DRAFT)
                .endTime(request.endTime())
                .createdBy(authUser)
                .build();

        groupRepository.save(group);
    }

    public void getAllGroups() {

    }


}
