package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository {
    List<Category> findAll();

    Optional<Category> getCategoryById(int category);
}
