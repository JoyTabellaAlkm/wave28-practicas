package com.meli.be_java_hisp_w28_g01.repository.impl;

import com.meli.be_java_hisp_w28_g01.model.Post;
import com.meli.be_java_hisp_w28_g01.repository.IPostRepository;
import com.meli.be_java_hisp_w28_g01.util.DataLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    private final List<Post> listOfPosts;

    public PostRepositoryImpl(DataLoader dataLoader, @Value("${post.file.path}") String filePath)  {
        listOfPosts = dataLoader.loadDataBase(filePath, Post.class);
    }

    @Override
    public List<Post> getAll() {
        return listOfPosts;
    }

    @Override
    public boolean add(Post post) {
        return listOfPosts.add(post);
    }
}
