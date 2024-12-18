package com.api.social_meli.repository.impl;

import com.api.social_meli.model.Post;
import com.api.social_meli.repository.IPostRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl extends BaseRepository<Post> implements IPostRepository {


    public PostRepositoryImpl() {
        loadDataBase("posts");
    }

    @Override
    public List<Post> findByUserId(int userId) {
        return entities.stream()
                .filter(x -> x.getSeller().getUserId() == userId)
                .toList();
    }

}