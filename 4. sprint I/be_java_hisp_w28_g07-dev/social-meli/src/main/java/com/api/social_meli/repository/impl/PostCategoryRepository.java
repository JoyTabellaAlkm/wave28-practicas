package com.api.social_meli.repository.impl;

import com.api.social_meli.model.PostCategory;
import com.api.social_meli.repository.IPostCategoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PostCategoryRepository extends BaseRepository<PostCategory> implements IPostCategoryRepository {
    public PostCategoryRepository() {
        loadDataBase("postcategory");
    }
}
