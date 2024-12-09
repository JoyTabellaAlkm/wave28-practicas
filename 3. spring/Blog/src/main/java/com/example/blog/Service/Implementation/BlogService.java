package com.example.blog.Service.Implementation;

import com.example.blog.DTO.EntryBlogDTO;
import com.example.blog.Exceptions.ExistsEntry;
import com.example.blog.Exceptions.NotFound;
import com.example.blog.Model.EntryBlog;
import com.example.blog.Repository.Implementation.BlogRepositoryImpl;
import com.example.blog.Repository.iBlogRepository;
import com.example.blog.Service.iBlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements iBlogService {

    @Autowired
    private iBlogRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean createEntryBlog(EntryBlogDTO entryBlogDTO) {
        if( repository.existsBlog(entryBlogDTO.getId()) ) {
            throw new ExistsEntry("ID Already Exists");
        }
        EntryBlog entryBlog = objectMapper.convertValue(entryBlogDTO, EntryBlog.class);
        return repository.createBlog(entryBlog);
    }

    @Override
    public EntryBlogDTO getEntryById(int id) {
        if( !repository.existsBlog(id) ){
            throw new NotFound("ID Not Found");
        }

        return objectMapper.convertValue(repository.getBlog(id), EntryBlogDTO.class);
    }

    @Override
    public List<EntryBlogDTO> findAll() {
        List<EntryBlog> db = repository.getAllBlog();
        if( db.isEmpty() )
            throw new NotFound("Not Found");
        return db.stream().map(entryBlog -> objectMapper.convertValue(entryBlog, EntryBlogDTO.class)).collect(Collectors.toList());
    }
}
