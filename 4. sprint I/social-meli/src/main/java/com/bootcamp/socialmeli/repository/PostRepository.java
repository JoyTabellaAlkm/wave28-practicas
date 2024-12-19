package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.Post;
import com.bootcamp.socialmeli.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository {
    private List<Post> posts = new ArrayList<>();

    public PostRepository() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public void addPromotionalPost(Post post) {
        posts.add(post);
    }

    private void loadDataBase() throws IOException {
        posts = Utils.loadDataBase("posts", new TypeReference<List<Post>>() {
        });
    }
}
