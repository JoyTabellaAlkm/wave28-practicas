package com.bootcamp.blog.repository.impl;

import com.bootcamp.blog.model.Blog;
import com.bootcamp.blog.repository.IBlogRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    private List<Blog> listaEntradas;

    public BlogRepositoryImpl(List<Blog> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }
    public List<Blog> listAll(){
        return listaEntradas;
    }

    public boolean create(Blog e){
        return listaEntradas.add(e);
    }
    public int getAmountSize(){
        return listaEntradas.size();
    }
}
