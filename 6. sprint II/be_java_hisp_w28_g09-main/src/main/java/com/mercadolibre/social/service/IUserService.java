package com.mercadolibre.social.service;


import com.mercadolibre.social.dto.response.*;


public interface IUserService {
    FollowUserResponseDto followUser(int userId, int userIdToFollow);

    FollowersByUserDto followersByUser(Integer id, String order);

    MessageDto unfollowUser(int userId, int userIdToUnfollow);

    FollowedByUserDto followedByUser(Integer id, String order);

    UserCountFollowersDto getCountFollowers(int userId);
}
