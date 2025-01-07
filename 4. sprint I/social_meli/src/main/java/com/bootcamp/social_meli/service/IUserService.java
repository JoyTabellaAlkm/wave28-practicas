package com.bootcamp.social_meli.service;

import com.bootcamp.social_meli.dto.UserDTO;
import com.bootcamp.social_meli.dto.SimpleMessageDTO;
import com.bootcamp.social_meli.dto.response.*;
import com.bootcamp.social_meli.model.User;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAll();
    String followUser(Long userId, Long userToFollowId);
    String unfollowUser(Long userId, Long userToFollowId);
    FollowersListDTO findFollowersList(String userId);
    FollowedListDTO findFollowedList(String userId);
    FollowersListDTO findFollowersList(String userId, String order);
    FollowedListDTO findFollowedList(String userId, String order);
    FollowerCountResponse getFollowerCount(Long userId);
    MostFollowersResponseDTO mostFollowers();
    MostFollowersResponseDTO mostFollowers(Integer rank);
    UserDetailsDTO metricsUserDetails(Long userId);
    UserDTO createUser(UserDTO userDto);
}
