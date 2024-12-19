package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.response.UserFollowedDto;
import com.bootcamp.socialmeli.dto.response.UserIdentificationDto;
import com.bootcamp.socialmeli.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.socialmeli.dto.response.UserFollowingSellerResponseDto;
import com.bootcamp.socialmeli.entity.User;

import java.util.List;

public class UserMapper {
    public static UserFollowedDto mapToUserFollowedDto(User user, List<User> followingUsers) {
        UserFollowedDto dto = new UserFollowedDto();

        dto.setId(user.getId());
        dto.setName(user.getName());

        List<UserIdentificationDto> followingUsersDto = UserMapper.mapUsersToUserIdentificationDto(followingUsers);
        dto.setFollowing(followingUsersDto);

        return dto;
    }

    public static UserFollowersCountResponseDto mapToUsersFollowersCountResponseDTO(User user, int followersCount) {
        return new UserFollowersCountResponseDto(user.getId(), user.getName(), followersCount);
    }

    public static UserFollowingSellerResponseDto mapToUsersFollowingSellerResponseDto(User user, List<UserIdentificationDto> followersDtos) {
        UserFollowingSellerResponseDto dto = new UserFollowingSellerResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setFollowers(followersDtos);
        return dto;
    }

    public static List<UserIdentificationDto> mapUsersToUserIdentificationDto(List<User> users) {
        return users
                .stream()
                .map(UserMapper::mapToUserIdentificationDto)
                .toList();
    }

    private static UserIdentificationDto mapToUserIdentificationDto(User user) {
        UserIdentificationDto dto = new UserIdentificationDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return dto;
    }
}
