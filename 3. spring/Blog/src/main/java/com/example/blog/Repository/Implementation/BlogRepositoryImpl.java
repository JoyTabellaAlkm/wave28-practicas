package com.example.blog.Repository.Implementation;


import com.example.blog.Model.EntryBlog;
import com.example.blog.Repository.iBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements iBlogRepository {
    private List<EntryBlog> db;

    BlogRepositoryImpl(){
        db = new ArrayList<>();
    }

    @Override
    public boolean createBlog(EntryBlog entryBlog) {
        return db.add(entryBlog);
    }

    @Override
    public boolean existsBlog(int id) {
        return db.stream().anyMatch(entryBlog -> entryBlog.getId() == id);
    }

    @Override
    public EntryBlog getBlog(int id) {
        return db.stream().filter(entryBlog -> entryBlog.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<EntryBlog> getAllBlog() {
        return db;
    }
}
