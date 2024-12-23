package com.bootcamp.social_meli.repository;

import com.bootcamp.social_meli.model.User;

import java.util.List;

public interface IUserRepository extends ICrudRepository<User, Long> {
    List<User> findFollowsByUserId(Long id);
    void createBatch(List<User> users);
    User findByUsername(String username);
}
