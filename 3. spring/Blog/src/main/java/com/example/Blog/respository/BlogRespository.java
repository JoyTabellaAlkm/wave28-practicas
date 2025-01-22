package com.example.Blog.respository;

import com.example.Blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRespository {

    public List<Blog> listBlogs = new ArrayList<>();

    public Blog addBlog(Blog blog) {
        try {
            listBlogs.add(blog);
        }catch (Exception e){
            return null;
        }
        return blog;
    }

    public List<Blog> getAllBlogs() {
        return listBlogs;
    }
}
