package com.api.social_meli.repository;

import com.api.social_meli.model.PostCategory;
import com.api.social_meli.model.Product;

import java.util.List;

public interface IPostCategoryRepository {
    List<PostCategory> findAll();
    PostCategory findById(int id);
    boolean exists(int id);
}
