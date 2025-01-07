package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.response.UnfollowResponseDTO;
import com.bootcamp.socialmeli.dto.response.FollowerCountDTO;
import com.bootcamp.socialmeli.dto.response.GetFollowedDTO;
import com.bootcamp.socialmeli.dto.response.GetFollowersDTO;
import com.bootcamp.socialmeli.dto.UserDto;
import com.bootcamp.socialmeli.dto.request.UserCreationReqDto;
import java.util.List;
import java.util.Optional;

import com.bootcamp.socialmeli.dto.response.FollowUserDto;
import com.bootcamp.socialmeli.model.User;

public interface UserService {
    FollowUserDto followUser(Long followerId,Long followedId);
    List<UserDto> createUsers(List<UserCreationReqDto> usersDto);
    UnfollowResponseDTO unfollowUser(Long userId, Long userIdToUnfollow);
    FollowerCountDTO getFollowersCount(Long userId);
    GetFollowedDTO getFollowedByUserId(Long id, String order);
    GetFollowersDTO getFollowersByUserId(Long id, Optional<String> order);
    void deletePostsByUser(Long id);
    FollowerCountDTO getMaxFollowersCount();
}
