package uz.salikhdev.google_lms.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.salikhdev.google_lms.domain.dto.request.UserResponse;
import uz.salikhdev.google_lms.domain.entity.user.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullName", expression = "java(user.getFirstName() + \" \" + user.getLastName())")
    UserResponse userToUserResponse(User user);

    List<UserResponse> usersToUserResponses(List<User> users);
}
