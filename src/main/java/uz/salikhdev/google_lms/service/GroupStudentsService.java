package uz.salikhdev.google_lms.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import uz.salikhdev.google_lms.domain.dto.request.GroupStudentsRequest;
import uz.salikhdev.google_lms.domain.dto.request.UpdateGroupStudentsRequest;
import uz.salikhdev.google_lms.domain.dto.request.UserResponse;
import uz.salikhdev.google_lms.domain.dto.response.GroupResponse;
import uz.salikhdev.google_lms.domain.entity.academic.Group;
import uz.salikhdev.google_lms.domain.entity.academic.GroupStudents;
import uz.salikhdev.google_lms.domain.entity.user.User;
import uz.salikhdev.google_lms.exception.BadRequestException;
import uz.salikhdev.google_lms.exception.NotFoundException;
import uz.salikhdev.google_lms.mapper.GroupMapper;
import uz.salikhdev.google_lms.mapper.UserMapper;
import uz.salikhdev.google_lms.repository.GroupRepository;
import uz.salikhdev.google_lms.repository.GroupStudentsRepository;
import uz.salikhdev.google_lms.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupStudentsService {
    private final GroupStudentsRepository groupStudentsRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final UserMapper userMapper;
    private final GroupMapper groupMapper;


    public void join(GroupStudentsRequest request) {
        User student = userRepository.findByIdAndStatus(request.studentId(), User.Status.ACTIVE)
                .orElseThrow(()-> new NotFoundException("Student not found"));
        if(student.getRole() != User.Role.STUDENT){
            throw new BadRequestException("Only student can join");
        }
        Group group = groupRepository.findById(request.groupId())
                .orElseThrow(()-> new NotFoundException("Group not found"));

        GroupStudents groupStudents = GroupStudents.builder()
                .student(student)
                .group(group)
                .joinedAt(LocalDate.now())
                .status(GroupStudents.Status.ACTIVE)
                .build();
        groupStudentsRepository.save(groupStudents);
    }
    public void update(UpdateGroupStudentsRequest request) {
        User student = userRepository.findByIdAndStatus(request.studentId(), User.Status.ACTIVE)
                .orElseThrow(()-> new NotFoundException("Student not found"));
        Group group = groupRepository.findById(request.groupId())
                .orElseThrow(()-> new NotFoundException("Group not found"));
        GroupStudents groupStudents = groupStudentsRepository.findById(request.groupStudentsId())
                .orElseThrow(()-> new NotFoundException("GroupStudents not found"));
        groupStudents.setJoinedAt(LocalDate.now());
        groupStudents.setStatus(GroupStudents.Status.ACTIVE);
        groupStudents.setStudent(student);
        groupStudents.setGroup(group);
        groupStudentsRepository.save(groupStudents);
    }

    public List<UserResponse> getStudents(Long groupId) {
        List<User> students = groupStudentsRepository.findByGroupId(groupId);
        return userMapper.usersToUserResponses(students);
    }
    public List<GroupResponse> getGroups(Long studentId) {
        List<Group> groups= groupStudentsRepository.findByStudentId(studentId);
        return groupMapper.toResponse(groups);
    }
}
