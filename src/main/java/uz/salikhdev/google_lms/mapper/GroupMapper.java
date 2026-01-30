package uz.salikhdev.google_lms.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uz.salikhdev.google_lms.domain.dto.response.GroupResponse;
import uz.salikhdev.google_lms.domain.entity.academic.Group;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper {


    @Mapping(target = "status", source = "status")
    GroupResponse toResponse(Group group);

    List<GroupResponse> toResponse(List<Group> groups);
}
