package com.demo.demo.repository;

import com.demo.demo.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EntradaBlogRepository {
    private Map<Integer, EntradaBlog> blogs = new HashMap<>();

    public boolean alreadyExists(Integer id) {
        return blogs.containsKey(id);
    }

    public Integer save(EntradaBlog blog) {
        blogs.put(blog.getId(), blog);
        return blog.getId();
    }

}
