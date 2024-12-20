package com.mercadolibre.social.repository;

import com.mercadolibre.social.entity.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> findAll();

    Post save(Post post);

    Post findById(Integer id);

    List<Post> findByProductId(Integer id);
}
