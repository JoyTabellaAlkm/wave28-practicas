package com.api.social_meli.repository.impl;

import com.api.social_meli.model.User;
import com.api.social_meli.repository.IUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends BaseRepository<User> implements IUserRepository {

    public UserRepositoryImpl() {
        loadDataBase("users");
    }

}
