package com.api.social_meli.repository.impl;

import com.api.social_meli.model.User;
import com.api.social_meli.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl extends BaseRepository<User> implements IUserRepository {

    public UserRepositoryImpl() {
        loadDataBase("users");
    }

    public List<Integer> getFollowedsByUserId(int userId) {
        return entities.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst().get().getFollowed();
    }

    @Override
    public List<Integer> getFollowersByUserId(int userId) {
        return entities.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst().get().getFollowers();
    }
}
