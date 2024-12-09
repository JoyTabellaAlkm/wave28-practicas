package com.example.blog.Service;

import com.example.blog.DTO.EntryBlogDTO;
import com.example.blog.Model.EntryBlog;
import java.util.List;

public interface iBlogService {
    boolean createEntryBlog(EntryBlogDTO entryBlogDTO);
    EntryBlogDTO getEntryById(int id);
    List<EntryBlogDTO> findAll();
}
