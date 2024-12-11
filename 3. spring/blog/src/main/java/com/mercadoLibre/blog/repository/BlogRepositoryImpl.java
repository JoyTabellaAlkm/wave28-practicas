package com.mercadoLibre.blog.repository;

import com.mercadoLibre.blog.dto.BlogDTO;
import com.mercadoLibre.blog.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogRepositoryImpl implements IBlogRepository {
    private List<Blog> blogs = new ArrayList<>();

    @Override
    public long agregarBlog(Blog blogAAgregar) {
        blogs.add(blogAAgregar);
        return blogAAgregar.getId();
    }

    @Override
    public Blog buscarBlogPorId(long id) {
        Blog blogEncontrado = blogs.stream()
                .filter(b-> b.getId()==id).findFirst().orElse(null);
        return blogEncontrado;
    }

    @Override
    public boolean blogExiste(long id) {
        return blogs.stream().anyMatch(b-> b.getId()==id);
    }

    @Override
    public List<Blog> traerTodosBlogs() {
        return blogs;
    }
}
