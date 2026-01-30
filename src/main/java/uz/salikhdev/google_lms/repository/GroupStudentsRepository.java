package uz.salikhdev.google_lms.repository;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.salikhdev.google_lms.domain.entity.academic.Group;
import uz.salikhdev.google_lms.domain.entity.academic.GroupStudents;
import uz.salikhdev.google_lms.domain.entity.user.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupStudentsRepository extends JpaRepository<GroupStudents, Long> {


    @EntityGraph(attributePaths = "user")
    List<User> findByGroupId(Long groupId);

    List<Group> findByStudentId(Long studentId);
}
