package com.example.blog.Repository;

import com.example.blog.Model.EntryBlog;
import java.util.List;


public interface iBlogRepository {
    boolean createBlog(EntryBlog entryBlog);
    boolean existsBlog(int id);
    EntryBlog getBlog(int id);
    List<EntryBlog> getAllBlog();
}
