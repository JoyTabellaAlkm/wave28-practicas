package com.bootcamp.socialmeli.repository.impl;

import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private Map<Long, User> userMap;
    private Long idCount;

    public UserRepositoryImpl() {
        userMap = new HashMap<>();
        idCount = 1L;
    }

    @Override
    public List<User> findAll() {
        return userMap.values().stream().toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public Long save(User user) {
        user.setId(idCount);
        userMap.put(idCount, user);
        return idCount++;
    }

    @Override
    public User deletePosts(User user) {
        user.setPosts(new ArrayList<>());
        return user;
    }

    @Override
    public Optional<User> findByMaxFollowers() {
        return userMap.values().stream().max(Comparator.comparingInt(user -> user.getFollowers().size()));
    }
}
