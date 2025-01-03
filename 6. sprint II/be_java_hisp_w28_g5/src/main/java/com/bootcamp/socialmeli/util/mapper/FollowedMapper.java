package com.bootcamp.socialmeli.util.mapper;

import com.bootcamp.socialmeli.dto.UserDto;
import com.bootcamp.socialmeli.dto.response.GetFollowedDTO;
import com.bootcamp.socialmeli.dto.response.GetFollowersDTO;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public class FollowedMapper {
    private FollowedMapper(){}

    public static GetFollowedDTO toGetFollowedDTO(User user){
        return new GetFollowedDTO(
                user.getId(),
                user.getName(),
                user.getFollowed().stream().map(follower -> new UserDto(
                        follower.getId(),
                        follower.getName()
                )).toList()
        );
    }

    public static GetFollowedDTO getFollowedDtoOrderByName(User user, List<User> followers){
        return new GetFollowedDTO(
                user.getId(),
                user.getName(),
                followers.stream().map(follower -> new UserDto(
                        follower.getId(),
                        follower.getName()
                )).toList()
        );
    }
}
