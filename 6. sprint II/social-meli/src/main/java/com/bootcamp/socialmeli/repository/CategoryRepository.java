package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.Category;
import com.bootcamp.socialmeli.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository implements ICategoryRepository {

    private List<Category> categories = new ArrayList<>();

    public CategoryRepository() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public Optional<Category> getCategoryById(int category) {
        return categories.stream()
                .filter(c -> c.getId() == category)
                .findAny();
    }

    private void loadDataBase() throws IOException {
        categories = Utils.loadDataBase("categories", new TypeReference<List<Category>>() {
        });
    }
}
