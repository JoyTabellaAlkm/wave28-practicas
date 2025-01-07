package com.bootcamp.social_meli.repository;

import com.bootcamp.social_meli.model.Post;
import com.bootcamp.social_meli.model.User;
import java.util.List;
import java.util.Optional;

public interface IPostRepository extends ICrudRepository<Post, Long> {
    List<Post> findAmountOfPromosByUserId(User user);
    List<Post> findByUserId(Long id);
    List<Post> findByUserIdFilteredByLastTwoWeeks(Long id);
    Post update(Post post);
    Optional<Post> findByUserIdAndProductId(Long userId, Long productId);
    void createBatch(List<Post> posts);
    List<Post> getPostsWithProduct(String productName);
    List<Post> getPostsByPriceRange(Double min, Double max);
}
