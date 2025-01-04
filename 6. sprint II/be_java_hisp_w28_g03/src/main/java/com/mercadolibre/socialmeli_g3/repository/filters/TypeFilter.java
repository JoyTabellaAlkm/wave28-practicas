package com.mercadolibre.socialmeli_g3.repository.filters;

import com.mercadolibre.socialmeli_g3.entity.Post;

import java.util.List;

public class TypeFilter implements IProductFilter{
    @Override
    public List<Post> filter(String criteria, List<Post> posts) {
        return posts.stream().filter(post -> post.getProduct().getType().toLowerCase().contains(criteria.toLowerCase())).toList();
    }
}
