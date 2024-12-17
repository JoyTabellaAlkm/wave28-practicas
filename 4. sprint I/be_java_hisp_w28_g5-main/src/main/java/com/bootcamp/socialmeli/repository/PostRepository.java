package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.model.Post;

import java.util.List;

public interface PostRepository {
    Long save(Post p);
    List<Post> findAll();
}
