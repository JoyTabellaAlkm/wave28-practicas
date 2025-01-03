package com.meli.be_java_hisp_w28_g01.service;

import com.meli.be_java_hisp_w28_g01.dto.response.FollowDto;
import com.meli.be_java_hisp_w28_g01.dto.response.FollowedSellersDto;
import com.meli.be_java_hisp_w28_g01.dto.response.FollowersDto;
import com.meli.be_java_hisp_w28_g01.model.Follow;

import java.util.List;

public interface IFollowService {
    FollowDto addFollow(int userId, int userIdToFollow);
    List<Follow> getAll();

    FollowedSellersDto getFollowedSeller(int userId);
    FollowersDto getFollowersCount(int userId);
    FollowedSellersDto getFollowedOrderedSeller(int userId, String order);
    FollowDto deleteFollow(int userId, int userIdToUnfollow);
}
