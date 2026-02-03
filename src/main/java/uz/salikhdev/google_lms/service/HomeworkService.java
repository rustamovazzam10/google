package uz.salikhdev.google_lms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.salikhdev.google_lms.domain.dto.request.HomeworkCreateRequest;
import uz.salikhdev.google_lms.domain.entity.academic.Group;
import uz.salikhdev.google_lms.domain.entity.academic.GroupHomework;
import uz.salikhdev.google_lms.domain.entity.academic.Homework;
import uz.salikhdev.google_lms.domain.entity.user.User;
import uz.salikhdev.google_lms.exception.ConflictException;
import uz.salikhdev.google_lms.exception.NotFoundException;
import uz.salikhdev.google_lms.mapper.HomeworkMapper;
import uz.salikhdev.google_lms.repository.GroupHomeworkRepository;
import uz.salikhdev.google_lms.repository.GroupRepository;
import uz.salikhdev.google_lms.repository.HomeworkRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class HomeworkService {

    private final HomeworkMapper homeworkMapper;
    private final HomeworkRepository homeworkRepository;
    private final GroupHomeworkRepository groupHomeworkRepository;
    private final GroupRepository groupRepository;


    // ================= Homework ================= //

    public void createHomework(HomeworkCreateRequest request) {

        if (homeworkRepository.existsByTitle(request.title())) {
            throw new ConflictException("Homework with this title already exists");
        }

        Homework entity = homeworkMapper.toEntity(request);
        homeworkRepository.save(entity);
    }

    private void deleteHomework(Long homeworkId) {
        if (!homeworkRepository.existsById(homeworkId)) {
            throw new ConflictException("Homework not found");
        }

        if (groupHomeworkRepository.existsByHomeworkId(homeworkId)) {
            throw new ConflictException("Cannot delete homework assigned to groups");
        }

        homeworkRepository.deleteById(homeworkId);
    }


    // ================= Group Homework ================= //

    public void attachHomeworkToGroup(User creator, Long homeworkId, Long groupId, LocalDateTime deadline) {

        Homework homework = homeworkRepository.findById(homeworkId)
                .orElseThrow(() -> new NotFoundException("Homework not found"));

        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new NotFoundException("Group not found"));

        GroupHomework groupHomework = GroupHomework.builder()
                .creator(creator)
                .homework(homework)
                .group(group)
                .deadline(deadline)
                .isSubmitted(false)
                .build();

        groupHomeworkRepository.save(groupHomework);
    }

}
