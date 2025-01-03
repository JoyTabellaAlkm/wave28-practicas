package com.mercadolibre.socialmeli_g3.service;
import com.mercadolibre.socialmeli_g3.dto.response.FollowedListDTO;
import com.mercadolibre.socialmeli_g3.dto.response.FollowersListDTO;
import com.mercadolibre.socialmeli_g3.dto.response.FollowDTO;

import com.mercadolibre.socialmeli_g3.dto.response.FollowersCountDTO;

public interface IUserService {

    FollowersListDTO getSellerFollowers(int userId);
    FollowedListDTO getFollowedByUserId(int id);
    boolean unfollow(int userId, int userIdToUnfollow);
    FollowDTO follow(int userId, int userIdToFollow);
    FollowersCountDTO getNumberFollowers(int userId);
    FollowersListDTO followersOrderBy(int userId, String order);
    FollowedListDTO followedOrderBy(int userId, String order);
    FollowersListDTO getFollowersByUsername(int userId, String username);

}
