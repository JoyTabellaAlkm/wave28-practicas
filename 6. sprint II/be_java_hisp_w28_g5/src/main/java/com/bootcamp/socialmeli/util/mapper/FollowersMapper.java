package com.bootcamp.socialmeli.util.mapper;

import com.bootcamp.socialmeli.dto.UserDto;
import com.bootcamp.socialmeli.dto.response.GetFollowersDTO;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public class FollowersMapper {
    private FollowersMapper(){}

    public static GetFollowersDTO toGetFollowersDTO(User user){
        return new GetFollowersDTO(
                user.getId(),
                user.getName(),
                user.getFollowers().stream().map(follower -> new UserDto(
                        follower.getId(),
                        follower.getName()
                )).toList()
        );
    }

    public static GetFollowersDTO getFollowersDtoOrderByName(User user, List<User> followers){
        return new GetFollowersDTO(
                user.getId(),
                user.getName(),
                followers.stream().map(follower -> new UserDto(
                        follower.getId(),
                        follower.getName()
                )).toList()
        );
    }
}
