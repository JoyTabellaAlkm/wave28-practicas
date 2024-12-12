package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.Blog;

import java.util.List;

public interface IBlogRepository {
    public List<Blog> listAll();

    public boolean create(Blog e);
    public int getAmountSize();
}
