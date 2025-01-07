package com.bootcamp.socialmeli.repository.impl;

import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.repository.PostRepository;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final Map<Long, Post> data = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public Long save(Post p) {
        Long id = nextId++;
        p.setId(id);
        data.put(id, p);
        return id;
    }

    @Override
    public List<Post> findAll() {
        return data.values().stream().toList();
    }
}
