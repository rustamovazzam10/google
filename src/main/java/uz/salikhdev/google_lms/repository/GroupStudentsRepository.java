package uz.salikhdev.google_lms.repository;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.salikhdev.google_lms.domain.entity.academic.GroupStudents;

import java.util.List;

@Repository
public interface GroupStudentsRepository extends JpaRepository<GroupStudents, Long> {


    @EntityGraph(attributePaths = {"student"})
    List<GroupStudents> findAllByGroup_Id(Long groupId);

    @EntityGraph(attributePaths = {"group"})
    List<GroupStudents> findAllByStudent_Id(Long studentId);

}
