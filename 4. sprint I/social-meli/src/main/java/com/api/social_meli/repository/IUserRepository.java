package com.api.social_meli.repository;

import com.api.social_meli.model.User;
import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    User findById(int id);
    boolean exists(int id);
    List<Integer> getFollowedsByUserId(int userId);
    User create(User user);
    List<Integer> getFollowersByUserId(int userId);
}
