package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepository {

    private Map<Integer, Blog> mapaBlog = new HashMap<>();

    public List<Blog> obtenerBlogs(){
        return mapaBlog.values().stream().toList();
    }

    public Blog obtenerBlog(Integer id){
        return mapaBlog.get(id);
    }

    public Integer  agregarBlog(Blog nuevoBlog){
        mapaBlog.put(nuevoBlog.getId(), nuevoBlog);
        return nuevoBlog.getId();
    }
}
