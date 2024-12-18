package com.api.social_meli.repository;

import com.api.social_meli.model.Post;
import java.util.List;

public interface IPostRepository {
    List<Post> findAll();
    List<Post> findByUserId(int userId);
    Post create(Post entity);
    boolean exists(int id);
    Post findById(int id);
}
