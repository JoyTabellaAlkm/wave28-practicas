package com.meli.be_java_hisp_w28_g01.repository;

import com.meli.be_java_hisp_w28_g01.model.Post;

import java.util.List;

public interface IPostRepository {
    public List<Post> getAll();
    public boolean add(Post post);
}
