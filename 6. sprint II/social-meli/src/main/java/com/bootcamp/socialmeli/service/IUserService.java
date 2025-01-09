package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.request.GoalDto;
import com.bootcamp.socialmeli.dto.response.GoalResponseDto;
import com.bootcamp.socialmeli.dto.response.UserFollowedDto;
import com.bootcamp.socialmeli.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.socialmeli.dto.response.UserFollowingSellerResponseDto;

public interface IUserService {
    UserFollowedDto addFollower(int userId, int userIdToFollow);

    UserFollowedDto getFollowingList(int userId, String order);

    UserFollowedDto removeFollower(int userId, int userIdToUnfollow);

    UserFollowersCountResponseDto getAllUsersFollowersCount(int userId);

    UserFollowingSellerResponseDto getAllUsersFollowingSeller(int userId, String order);

    GoalResponseDto addGoal(int userId, GoalDto goalDto);

    GoalResponseDto getGoal(int userId);
}
