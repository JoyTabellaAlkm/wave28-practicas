package com.mercadolibre.socialmeli_g3.repository.filters;

import com.mercadolibre.socialmeli_g3.entity.Post;
import lombok.Data;

import java.util.List;

public interface IProductFilter {
    List<Post> filter(String criteria, List<Post> posts);
}
