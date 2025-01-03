package com.mercadolibre.socialmeli_g3.repository;

import com.mercadolibre.socialmeli_g3.entity.User;

import java.util.List;

import com.mercadolibre.socialmeli_g3.entity.User;

public interface IUserRepository {
    List<User> findAllUsers();
    User findUserById(int userId);
    void unfollow(User user, User userToUnfollow);
    User follow(User user, User userToFollow);
    List<User> findFollowersOrderedByName(int id, String order);
    List<User> findFollowedOrderedByName(int id, String order);
}
