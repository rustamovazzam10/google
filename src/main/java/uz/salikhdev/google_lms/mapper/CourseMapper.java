package uz.salikhdev.google_lms.mapper;


import org.mapstruct.Mapper;
import uz.salikhdev.google_lms.domain.dto.response.CourseResponse;
import uz.salikhdev.google_lms.domain.entity.academic.Course;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseResponse toResponse(Course course);

    List<CourseResponse> toResponse(List<Course> courses);
}
