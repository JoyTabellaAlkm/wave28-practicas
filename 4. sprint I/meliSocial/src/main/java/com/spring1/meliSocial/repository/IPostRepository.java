package com.spring1.meliSocial.repository;

import com.spring1.meliSocial.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostRepository {

    String saveNewPost(Post post);

    int lastId();

    void addNewProductPromo(Post product);

    Post getPostById(int id);

    boolean existsPost(int id);

    List<Post> getPosts();

    int countProductsOnPromo(int userId);

    void updatePromoDiscount(int id, double discount);

    List<Post> getBestProductsOnPromo();

    void updatePrice(int id, double newPrice);

}
