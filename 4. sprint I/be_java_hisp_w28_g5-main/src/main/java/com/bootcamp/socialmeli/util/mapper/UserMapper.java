package com.bootcamp.socialmeli.util.mapper;

import com.bootcamp.socialmeli.dto.UserDto;
import com.bootcamp.socialmeli.dto.request.UserCreationReqDto;
import com.bootcamp.socialmeli.dto.response.UnfollowResponseDTO;
import com.bootcamp.socialmeli.model.User;

public class UserMapper {
    private UserMapper() {}

    public static User toUser(UserCreationReqDto u) {
        User user = new User();
        user.setName(u.getName());
        return user;
    }

    public static UserDto toUserDto(User u) {
        return new UserDto(u.getId(), u.getName());
    }

    public static UnfollowResponseDTO toUnfollowResponseDTO(User user) {
        return new UnfollowResponseDTO(
                user.getId(),
                user.getName(),
                user.getFollowed().stream().map(UserMapper::toUserDto).toList()
        );
    }
}
