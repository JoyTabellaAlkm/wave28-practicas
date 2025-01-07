package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public List<User> findAll();
    public Optional<User> findById(Long id);
    public Long save(User user);
    public User deletePosts(User user);
    Optional<User> findByMaxFollowers();
}
