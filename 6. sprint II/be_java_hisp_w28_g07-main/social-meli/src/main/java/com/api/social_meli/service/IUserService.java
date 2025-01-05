package com.api.social_meli.service;

import com.api.social_meli.dto.*;
import com.api.social_meli.dto.FollowedListDto;
import com.api.social_meli.dto.MessageDto;
import com.api.social_meli.dto.GetFollowerCountDto;

import java.util.List;

public interface IUserService {

    GetFollowerCountDto getFollowerCount(int userId);
    MessageDto unfollowUser(int userId, int userIdToUnfollow);
    FollowerListDto getFollowersOrderedByName(int userId, String order);
    FollowedListDto getFollowedsOrderedByName(int userId, String order);
    MessageDto followUser(int userId, int userIdToFollow);
    List<UserDto> searchAllUsers();
    MessageDto favouritePost(FavouritePostRequestDto dto);
    MessageDto unfavouritePost(FavouritePostRequestDto dto);
    GetFavouritePostsResponseDto getFavouritePosts(int userId);
}
