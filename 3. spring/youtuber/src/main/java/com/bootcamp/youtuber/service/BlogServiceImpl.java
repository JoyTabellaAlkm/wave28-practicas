package com.bootcamp.youtuber.service;

import com.bootcamp.youtuber.exception.BlogExistenteException;
import com.bootcamp.youtuber.exception.BlogNoExistenteException;
import com.bootcamp.youtuber.dto.EntradaBlogDto;
import com.bootcamp.youtuber.repository.EntradaBlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private EntradaBlogDao entradaBlogDao;

    @Override
    public void create(EntradaBlogDto entradaBlog) {
        entradaBlogDao.findById(entradaBlog.getId())
                .ifPresentOrElse(blog -> {throw new BlogExistenteException(blog.getId());}, () -> entradaBlogDao.save(entradaBlog));
    }

    @Override
    public EntradaBlogDto getBlogBy(Long id) {
        return entradaBlogDao.findById(id).orElseThrow(() -> new BlogNoExistenteException(id));
    }

    @Override
    public List<EntradaBlogDto> getAllBlogs() {
        return entradaBlogDao.findAll();
    }
}
