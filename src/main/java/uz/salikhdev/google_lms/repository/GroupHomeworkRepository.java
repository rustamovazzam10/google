package uz.salikhdev.google_lms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.salikhdev.google_lms.domain.entity.academic.GroupHomework;

@Repository
public interface GroupHomeworkRepository extends JpaRepository<GroupHomework, Long> {
    boolean existsByHomeworkId(Long homeworkId);
}
