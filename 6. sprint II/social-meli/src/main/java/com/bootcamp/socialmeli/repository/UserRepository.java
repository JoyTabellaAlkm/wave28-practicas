package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.User;
import com.bootcamp.socialmeli.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() throws IOException {
        loadDataBase();
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> getUserById(int userId) {
        return users.stream()
                .filter(user -> user.getId() == userId)
                .findAny();
    }

    @Override
    public List<User> getUsersByIds(List<Integer> userIds) {
        return userIds.stream()
                .map(this::getUserById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    private void loadDataBase() throws IOException {
        users = Utils.loadDataBase("users", new TypeReference<List<User>>() {
        });
    }
}
