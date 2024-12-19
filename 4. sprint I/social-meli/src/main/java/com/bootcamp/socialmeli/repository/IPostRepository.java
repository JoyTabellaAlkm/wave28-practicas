package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> findAll();

    void addPromotionalPost(Post post);
}
