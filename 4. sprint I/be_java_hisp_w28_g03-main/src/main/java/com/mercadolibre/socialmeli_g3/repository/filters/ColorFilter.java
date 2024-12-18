package com.mercadolibre.socialmeli_g3.repository.filters;

import com.mercadolibre.socialmeli_g3.entity.Post;

import java.util.List;

public class ColorFilter implements IProductFilter{
    @Override
    public List<Post> filter(String criteria, List<Post> posts) {
        return posts.stream().filter(post -> post.getProduct().getColor().toLowerCase().contains(criteria.toLowerCase())).toList();

    }
}
