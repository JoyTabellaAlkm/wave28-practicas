package com.spring1.meliSocial.service;


import com.spring1.meliSocial.dto.response.*;

import java.util.List;

public interface IUserService {
    SellerFollowedDto getFollowersFromSeller(int sellerId, String orderMethod);

    FollowedByUserDto getFollowedByUser(int userId, String orderMethod);

    UserFollowersDto findFollowers(int id);

    ResponseDto unfollowUser(int userId, int userIdToUnfollow);

    ResponseDto followUser(int userId, int userIdToFollow);

    ResponseDto addFavouritePost(int userId, int postId);

    void removeFavouritePost(int userId, int postId);

    FavouritePostsDto getFavouritePostsFromUser(int userId);
}
