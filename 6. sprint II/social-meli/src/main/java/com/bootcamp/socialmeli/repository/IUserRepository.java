package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();

    Optional<User> getUserById(int userId);

    List<User> getUsersByIds(List<Integer> userIds);
}
