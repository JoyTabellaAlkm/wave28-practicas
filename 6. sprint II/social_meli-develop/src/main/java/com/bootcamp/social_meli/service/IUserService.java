package com.bootcamp.social_meli.service;

import com.bootcamp.social_meli.dto.request.UserDTO;
import com.bootcamp.social_meli.dto.request.CreateUserRequestDTO;
import com.bootcamp.social_meli.dto.response.*;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAll();
    String followUser(Long userId, Long userToFollowId);
    String unfollowUser(Long userId, Long userToFollowId);
    FollowersListResponseDTO findFollowersList(Long userId);
    FollowedListResponseDTO findFollowedList(Long userId);
    FollowersListResponseDTO findFollowersList(Long userId, String order);
    FollowedListResponseDTO findFollowedList(Long userId, String order);
    FollowerCountResponse getFollowerCount(Long userId);
    MostFollowersResponseDTO mostFollowers();
    MostFollowersResponseDTO mostFollowers(Integer rank);
    UserDetailsResponseDTO metricsUserDetails(Long userId);
    UserDTO createUser(CreateUserRequestDTO userDto);
}
