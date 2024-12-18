package com.mercadolibre.sprint1.service;

import com.mercadolibre.sprint1.dto.response.FollowersCountDto;
import com.mercadolibre.sprint1.dto.response.UnfollowResponseDto;

public interface IUserFollowerService {

    UnfollowResponseDto unfollow(int userId, int sellerId);

    FollowersCountDto followersCount(int userId);
}
