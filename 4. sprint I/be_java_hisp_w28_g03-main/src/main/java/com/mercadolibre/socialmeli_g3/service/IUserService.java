package com.mercadolibre.socialmeli_g3.service;
import com.mercadolibre.socialmeli_g3.dto.FollowedListDTO;
import com.mercadolibre.socialmeli_g3.dto.FollowersListDTO;
import com.mercadolibre.socialmeli_g3.dto.response.FollowDTO;

import com.mercadolibre.socialmeli_g3.dto.FollowersCountDTO;
import com.mercadolibre.socialmeli_g3.dto.UserDTO;

import java.util.List;

public interface IUserService {

    FollowersListDTO getSellerFollowers(int userId);

    FollowedListDTO getFollowedByUserId(int id);

    void unfollow(int userId, int userIdToUnfollow);
    FollowDTO follow(int userId, int userIdToFollow);
    FollowersCountDTO getNumberFollowers(int userId);
    FollowersListDTO followersOrderBy(int userId, String order);
    FollowedListDTO followedOrderBy(int userId, String order);
    FollowersListDTO getFollowersByUsername(int userId, String username);

}
